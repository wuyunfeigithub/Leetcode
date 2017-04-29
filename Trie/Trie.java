/*
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */

public class Trie {

	TrieNode root;
	
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
        	char c = word.charAt(i);
        	if(cur.nextMap[c - 'a'] == null){
        		cur.nextMap[c - 'a'] = new TrieNode(c);
        	}
        	cur = cur.nextMap[c - 'a'];
        }
		cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
        	char c = word.charAt(i);
        	if(cur.nextMap[c - 'a'] == null)	return false;
        	cur = cur.nextMap[c - 'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
        	char c = prefix.charAt(i);
        	if(cur.nextMap[c - 'a'] == null)	return false;
        	cur = cur.nextMap[c - 'a'];
        }
        return true;
    }
    
	class TrieNode{
		char value;
		TrieNode[] nextMap;
		boolean isWord;
		
		public TrieNode(char c){
			this();
			value = c;
		}
		
		public TrieNode(){
			value = ' ';
			isWord = false;
			nextMap = new TrieNode[26];
		}	
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */