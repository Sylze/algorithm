package nowcoder;

import java.util.*;

/**
 * Created by SZ on 2017/8/9.
 */
public class MixColors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            Map<Integer, Set<Integer>> map = new HashMap<>();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                if(!map.containsKey(nums[i])) {
                    Set<Integer> index = new HashSet<>();
                    index.add(i);
                    map.put(nums[i], index);
                }
            }
            int newColor;
            for(int i = 0; i < n - 1; i++) {
                newColor = nums[i];
                for(int j = i + 1; j < n; j++) {
                    newColor ^= nums[j];
                    if(map.containsKey(newColor)) {
                        Set<Integer> indexSet = map.get(newColor);
                        if(!indexSet.contains(i) && !indexSet.contains(j)) {
                            indexSet.clear();
                            for(int k = i; k <= j; k++) {
                                indexSet.addAll(map.get(nums[i]));
                            }
                        }
                    }
                }
            }
            Set<Integer> res = new HashSet<>();
            for(Set<Integer> set : map.values()) {
                res.addAll(set);
            }
            for(Integer i : res) {
                System.out.println(nums[i]);
            }
            System.out.println(res.size());
        }
    }
}
