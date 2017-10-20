package nowcoder;

import java.util.*;

/**
 * Created by SZ on 2017/8/12.
 * 拼多多面试题
 */
public class DifferentNumberCombinations {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Map<String, Integer> map = new HashMap<>();
            List<String> addList = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if(!map.isEmpty()) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        int lastNum = entry.getValue();
                        if (arr[i] > lastNum) {
                            addList.add(entry.getKey() + "_" + arr[i]);
                        }
                    }
                }
                for (String s : addList) {
                    Integer v = map.get(s);
                    if(v != null) {
                        v = Math.min(v, arr[i]);
                    } else {
                        v = arr[i];
                    }
                    map.put(s, v);
                }
                addList.clear();
                String single = String.valueOf(arr[i]);
                if(!map.containsKey(single)) map.put(single, arr[i]);
            }
            int res = 0;
            for (String s : map.keySet()) {
                if(s.split("_").length > 1) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
