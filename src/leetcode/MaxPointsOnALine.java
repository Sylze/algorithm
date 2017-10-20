package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		if (points.length <= 2)
			return points.length;

		Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int overlap = 0, max = 0;
			for (int j = i + 1; j < points.length; j++) {
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if (x == 0 && y == 0) {
					overlap++;
					continue;
				}
				int gcd = generateGCD(x, y);
				x /= gcd;
				y /= gcd;

				if (map.containsKey(x)) {
					if (map.get(x).containsKey(y)) {
						map.get(x).put(y, map.get(x).get(y) + 1);
					} else {
						map.get(x).put(y, 1);
					}
				} else {
					Map<Integer, Integer> m = new HashMap<Integer, Integer>();
					m.put(y, 1);
					map.put(x, m);
				}
				max = Math.max(max, map.get(x).get(y));
			}
			result = Math.max(result, max + overlap + 1);
		}
		return result;

	}

	private int generateGCD(int a, int b) {

		if (b == 0)
			return a;
		else
			return generateGCD(b, a % b);

	}

	public static void main(String[] args) {
		MaxPointsOnALine mp = new MaxPointsOnALine();
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1, 0);
		Point p3 = new Point(3, 0);
		Point[] points = new Point[3];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		System.out.println(mp.maxPoints(points));
	}

}