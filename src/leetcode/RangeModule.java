package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by SZ on 2017/10/22.
 */
public class RangeModule {

    private TreeMap<Integer, Interval> treeMap;

    /**
     * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
     * addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
     * queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
     * removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
     */
    public RangeModule() {
        treeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Interval interval = merge(left, right);
        treeMap.put(interval.start, interval);
    }

    /**
     * 将当前区间合并到之前的区间,会在map中删除涉及的所有区间，返回新的区间
     * @param left
     * @param right
     * @return
     */
    private Interval merge(int left, int right) {
        //先找到包含left的区间（包括lowerInterval.end == left的情况）
        Interval interval = treeMap.get(left);
        if(interval == null) {
            Map.Entry<Integer, Interval> lowerEntry = treeMap.lowerEntry(left);
            if(lowerEntry != null && lowerEntry.getValue().end >= left) {
                interval = lowerEntry.getValue();
            }
        }
        //如果存在，更新left，right
        if(interval != null) {
            left = Math.min(left, interval.start);
            right = Math.max(right, interval.end);
        }
        treeMap.remove(left);
        //向右合并
        Map.Entry<Integer, Interval> higherEntry = treeMap.higherEntry(left);
        while (higherEntry != null) {
            if(higherEntry.getKey() > right) break;
            treeMap.remove(higherEntry.getKey());
            right = Math.max(right, higherEntry.getValue().end);
            higherEntry = treeMap.higherEntry(higherEntry.getKey());
        }
        return new Interval(left, right);
    }

    public boolean queryRange(int left, int right) {
        Interval interval = treeMap.get(left);
        if(interval != null) {
            return interval.end >= right;
        } else {
            Map.Entry<Integer, Interval> lowerEntry = treeMap.lowerEntry(left);
            return  lowerEntry != null && lowerEntry.getValue().end >= right;
        }
    }

    public void removeRange(int left, int right) {
        Interval interval = merge(left, right);
        //多删掉的区间补回来
        //处理左区间
        if(left > interval.start) {
            Interval leftInterval = new Interval(interval.start, left);
            treeMap.put(leftInterval.start, leftInterval);
        }
        //处理右区间
        if(right < interval.end) {
            Interval rightInterval = new Interval(right, interval.end);
            treeMap.put(rightInterval.start, rightInterval);
        }
    }

    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(27, 88);
        rm.removeRange(82, 83);
        rm.removeRange(30, 71);
        rm.addRange(31, 73);
        rm.addRange(10, 41);
        System.out.println(rm.queryRange(71, 72));
        System.out.println(rm.queryRange(9, 56));
        /*rm.addRange(10, 20);                        // null
        rm.removeRange(14, 16);                     // null
        System.out.println(rm.queryRange(10, 14));  // true (Every number in [10, 14) is being tracked)
        System.out.println(rm.queryRange(13, 15));  // false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
        System.out.println(rm.queryRange(16, 17));  // true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
    */
    }

}
