package leetcode;

public class CountPrimes {

	public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
        	isPrime[i] = true;
        }
        for(int i = 2; i * i < n; i++) {
        	if(!isPrime[i]) continue;
        	for(int j = i * i; j < n; j += i) {
        		isPrime[j] = false;
        	}
        }
        for(int k = 2; k < n; k++) {
        	if(!isPrime[k]) count++;
        }
        return count;
    }
	
	public static void main(String[] args) {
		CountPrimes sp = new CountPrimes();
		System.out.println(sp.countPrimes(10));
	}

}
