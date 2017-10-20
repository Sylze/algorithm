package sort;

import java.util.*;

/**
 * Created by SZ on 2017/9/26.
 * input:
 4 4
 1 2
 2 3
 3 5
 4 4
 1 2
 1 3
 2 4
 3 4
 * output:1 3 2 4
 */
public class TopologicalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), e = sc.nextInt();
            int[] weight = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int index = sc.nextInt();
                weight[index] = sc.nextInt();
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] inDegree = new int[n + 1];
            Arrays.fill(inDegree, 0);
            for (int i = 0; i < e; i++) {
                int vertex = sc.nextInt();
                int edge = sc.nextInt();
                inDegree[edge]++;
                List<Integer> edges = map.get(vertex);
                if(edges == null) {
                    edges = new LinkedList<>();
                    edges.add(edge);
                    map.put(vertex, edges);
                } else {
                    edges.add(edge);
                }
            }
            String s = topologicalSort(weight, map, inDegree);
            System.out.println(s);
        }
    }

    private static String topologicalSort(int[] weight, Map<Integer, List<Integer>> map, int[] inDegree) {
        int count = weight.length - 1;
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            int vertex = findNewVertexOfIndegreeZero(inDegree, weight);
            if(sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(vertex);
            inDegree[vertex] = -1; //表示vertex被访问过
            count--;
            List<Integer> edges = map.get(vertex);
            if(edges != null) {
                for (Integer edge : edges) {
                    inDegree[edge]--;
                }
            }
        }
        return sb.toString();
    }

    private static int findNewVertexOfIndegreeZero(int[] inDegree, int[] weight) {
        int max = 0;
        for (int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == 0 && (max == 0 || weight[i] > weight[max])) {
                max = i;
            }
        }
        return max;
    }
}
