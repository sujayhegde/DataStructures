package ds;

public class Trie {
	
	Node root; //represents root  of  the Trie
	
	public Trie(){
		this.root = new Node();
	}
	
	//Insert a string into Trie
	public  void insert(String src){
		if(null == src || 0 == src.length()){
			return;
		}
		
		Node cur = root;
		for(int i = 0; i < src.length(); i++){
			char c = Character.toLowerCase(src.charAt(i));
			if(cur.next[c - 'a'] == null){ //Path already exist ie  prefix exists
				Node newNode = new Node();
				cur.next[c - 'a'] = newNode;
				newNode.length = i + 1;
				cur = newNode;
			}
			else{
				cur = cur.next[c - 'a'];
			}
			
			
		}
		
		cur.isPresent = true; //The string src is actually present in the trie
		
		
	}
	
	public boolean matchExact(String src){
		if(null == src || 0 == src.length()){
			return false;
		}
		Node cur =this.root;
		for(int i = 0; i < src.length(); i++){
			char c = Character.toLowerCase(src.charAt(i));
			if(cur.next[c - 'a'] == null){
				return false;
			}
			else{
				cur = cur.next[c - 'a'];
			}
		}
		
		return true;
		
	}
	
	
	public int matchLongest(String src){
		if(null == src || 0 == src.length()){
			return -1;
		}
		int matchLength = 0;
		Node cur = this.root;
		for(int i = 0; i < src.length(); i++){
			if(null == cur){
				return matchLength;
			}
			char c = Character.toLowerCase(src.charAt(i));
			if(cur.next[c - 'a'] == null && matchLength == 0){
				return -1;
			}
			else{
				if(cur.isPresent = true){
					matchLength = cur.length;
				}
				cur = cur.next[c - 'a'];
			}
		}
		
		return matchLength;
		
	}
	
	public  boolean delete(String src){
		if(null == src || 0 == src.length()){
			return false;
		}
		
		if(!matchExact(src)){
			return false;
		}
		
		this.root.next[src.charAt(0) - 'a'] = null;
		
		return true;
	}
	
	
	
	
	
	
	private class Node{
		
		public int length;
		public boolean isPresent; //Node actually represents end of a string;
		public Node[] next;
		public final int  ALPHA_LENGTH = 26;
		
		public Node(){
			this.length = 0;
			this.isPresent = false;
			this.next = new Node[ALPHA_LENGTH];
		}
		
	}

}
