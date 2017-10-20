package leetcode;

import java.util.HashMap;
import java.util.Map;


public class CloneGraph {
	
	Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node == null) return null;
			return getResultNode(node);
	    }
	    
    private UndirectedGraphNode getResultNode(UndirectedGraphNode node) {
    	if(map.containsKey(node.label)) {
    		return map.get(node.label);
    	}
    	UndirectedGraphNode result = new UndirectedGraphNode(node.label);
    	map.put(result.label, result);
        if(node.neighbors != null) {
            for(UndirectedGraphNode ugd : node.neighbors) {
	            result.neighbors.add(getResultNode(ugd));
            }
        }
		return result;
    }
    
    /*private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }*/

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
