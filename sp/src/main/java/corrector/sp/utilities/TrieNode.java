package corrector.sp.utilities;

import java.util.HashMap;
import java.util.Set;

public class TrieNode {
	private HashMap<Character, TrieNode> children;
	private String text;
	private boolean isWord;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		text = "";
		isWord = false;
	}
	
	public TrieNode(String text) {
		this();
		this.text = text;
	}
	
	public TrieNode getChild(Character c) {
		return children.get(c);
	}
	
	public TrieNode insert(Character c) {
		if (children.containsKey(c)) {
			return null;
		}
		TrieNode next = new TrieNode(text + c.toString());
		children.put(c, next);
		
		return next;
	}
	
	/** Return the text string at this node */
    public String getText() {
		return text;
	}
	
    /** Set whether or not this node ends a word in the trie. */
	public void setEndsWord(boolean b) {
		isWord = b;
	}
	
	/** Return whether or not this node ends a word in the trie. */
	public boolean endsWord() {
		return isWord;
	}
	
	/** Return the set of characters that have links from this node */
	public Set<Character> getValidNextCharacters() {
		return children.keySet();
	}

}
