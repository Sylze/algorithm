package leetcode;

import java.util.HashMap;


public class BullsAndCows {
	
	public String getHint(String secret, String guess) {
        int bull = 0, cow = 0, value = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if(map.containsKey(guess.charAt(i))) {
                    value = map.get(guess.charAt(i));
                    map.put(guess.charAt(i) , value - 1);
                    if(value > 0) cow++;
                } else {
                    map.put(guess.charAt(i) , -1);
                }
                if(map.containsKey(secret.charAt(i))) {
                    value = map.get(secret.charAt(i));
                    map.put(secret.charAt(i) , value + 1);
                    if(value < 0) cow++;
                } else {
                    map.put(secret.charAt(i) , 1);
                }
            }
        }
        return bull + "Subsection" + cow + "B";
    }
	
	/*
	 * public String getHint(String secret, String guess) {
        int bull = 0, cow = 0, s, g;
        int[] nums = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            s = Character.getNumericValue(secret.charAt(i)); 
            g = Character.getNumericValue(guess.charAt(i)); 
            if(s == g) {
                bull++;
            } else {
                if(nums[s] < 0) cow++;
                if(nums[g] > 0) cow++;
                nums[s] = nums[s] + 1;
                nums[g] = nums[g] - 1;
            }
        }
        return bull + "Subsection" + cow + "B";
    }*/

	public static void main(String[] args) {
		Integer.reverse(78);
		BullsAndCows bac = new BullsAndCows();
		System.out.println(bac.getHint("1807", "7810"));
//		System.out.println(Integer.toBinaryString(0xff00ff00));
//		System.out.println(Integer.toBinaryString(0x00ff00ff));
//		System.out.println(Integer.toBinaryString(0xf0f0f0f0));
//		System.out.println(Integer.toBinaryString(0x0f0f0f0f));
//		System.out.println(Integer.toBinaryString(0xcccccccc));
//		System.out.println(Integer.toBinaryString(0x33333333));
//		System.out.println(Integer.toBinaryString(0xaaaaaaaa));
//		System.out.println(Integer.toBinaryString(0x55555555));
		
	}

}
