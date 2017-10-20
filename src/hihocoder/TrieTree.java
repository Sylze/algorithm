package hihocoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrieTree {

	private TrieNode root = new TrieNode();

	class TrieNode {
		private Character c;
		private int wordNum;
		private List<TrieNode> childNodes;

		public TrieNode() {
		}

		public TrieNode(Character ch) {
			this.c = ch;
			this.wordNum = 1;
		}

		public void insertWordAfter(String s) {
			if (s != null && s.length() > 0) {
				TrieNode temp = root;
				for (int i = 0; i < s.length(); i++) {
					temp = temp.insert(s.charAt(i));
				}
			}
		}

		private TrieNode insert(Character ch) {
			if (this.childNodes == null) {
				this.childNodes = new ArrayList<>();
			}
			TrieNode newNode = search(ch);
			if (newNode == null) {
				newNode = new TrieNode(ch);
				this.childNodes.add(newNode);
			} else {
				newNode.wordNum++;
			}
			return newNode;
		}

		private TrieNode search(Character ch) {
			for (TrieNode node : this.childNodes) {
				if (ch == node.c) {
					return node;
				}
			}
			return null;
		}
	}
	
	private int getNum(String s) {
		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			node = node.search(s.charAt(i));
			if (node == null) {
				return 0;
			}
		}
		return node.wordNum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TrieTree tt = new TrieTree();
		in.nextLine();//Çå³ý¿Õ°××Ö·û
		List<String> words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			words.add(in.nextLine());
		}
		int m = in.nextInt();
		in.nextLine();//Çå³ý¿Õ°××Ö·û
		List<String> input = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			input.add(in.nextLine());
		}
		for(String s : words) {
			tt.root.insertWordAfter(s);
		}
		for(String s : input) {
			System.out.println(tt.getNum(s));
		}
	}
	
	/* ²âÊÔÊäÈë
	 *  5
		babaab
		babbbaaaa
		abba
		aaaaabaa
		babaababb
		5
		babb
		baabaaa
		bab
		bb
		bbabbaab
		½á¹û 1 0 3 0 0
	 */

}
