import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Anagrams {

	public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Hashtable<Integer, List<String>> table = new Hashtable<Integer, List<String>>();
        int temp = 0;
        char[] cs = null;
        for(int i = 0; i < strs.length; i++) {
        	cs = strs[i].toCharArray();
        	Arrays.sort(cs);
            temp = cs.hashCode();
            System.out.println(String.valueOf(cs).hashCode());
            if(table.containsKey(temp)) {
                table.get(temp).add(strs[i]);
            } else {
            	List<String> value = new ArrayList<String>();
            	value.add(strs[i]);
                table.put(temp, value);
            }
        }
        for(List<String> value : table.values()) {
        	if(value.size() > 1) {
        		result.addAll(value);
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		Anagrams ans = new Anagrams();
		String[] strs = {"and","dan"};
		System.out.println(ans.anagrams(strs));
	}
}
