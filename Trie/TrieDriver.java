package ds;

public class TrieDriver {
	
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("good");
		trie.insert("bad");
		trie.insert("ugly");
		
		System.out.println(trie.matchExact("good"));
		System.out.println(trie.matchLongest("goodbye"));
		System.out.println(trie.matchExact("gugly"));
		
		System.out.println(trie.delete("good"));
		
		System.out.println(trie.matchExact("good"));
		System.out.println(trie.matchLongest("goodbye"));
	}

}
