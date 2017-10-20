package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			intervals.add(newInterval);
		} else {
			Collections.sort(intervals, new Comparator<Interval>() {
				@Override
				public int compare(Interval i1, Interval i2) {
					return Integer.compare(i1.start, i2.start);
				}
			});
			boolean isInsert = false;
			for (int i = 0; i < intervals.size(); i++) {
				Interval current = intervals.get(i);
				if (newInterval.start > current.end) {
					continue;
				} else if (newInterval.start < current.start) {
					if (newInterval.end < current.start) {
						intervals.add(newInterval);
						isInsert = true;
						break;
					} else if (newInterval.end > current.end) {
						intervals.remove(i);
						i--;
					} else {
						current.start = newInterval.start;
						isInsert = true;
						break;
					}
				} else {
					if (newInterval.end > current.end) {
						newInterval.start = current.start;
						intervals.remove(i);
						i--;
					} else {
						isInsert = true;
						break;
					}
				}
			}
			if(!isInsert) {
				intervals.add(newInterval);
			}
		}
		return intervals;
	}

	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 5));
		System.out.println(ii.insert(list, new Interval(2, 7)));
	}

}
