package leetcode;

public class EightQueen {
	
	private int[] rows;
	private int result = 0;

	private int anyQueen(int n) {
		result = 0;
		rows = new int[n];
		queen(0, n);
		return result;
	}
	

	private void queen(int i, int n) {
		if(i >= n) {
			output();
			result++;
		} else {
			for(int j = 0; j < n; j++) {
				int k = 0;
				rows[i] = j;
				while(k < i) {
					if((rows[i] != rows[k]) && (Math.abs(rows[i] - rows[k])) != Math.abs(k - i)) {
						k++;
					} else {
						break;
					}
				}
				if(i == 0 || k == i) queen(i + 1, n);
			}
		}
	}

	private void output() {
		for(int i = 0; i < rows.length; i++) {
			System.out.println("(" + i + ", " + rows[i] + ")");
		}
		System.out.println("-------");
	}

	public static void main(String[] args) {
		EightQueen e = new EightQueen();
		System.out.println(e.anyQueen(8));
	}
}
