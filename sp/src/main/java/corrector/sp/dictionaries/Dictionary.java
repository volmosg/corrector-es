package corrector.sp.dictionaries;

public interface Dictionary {

	//int size
	//Trie dictionary
	//Trie loadFromFile(file, isCaseSensitive)
	//addWord(word)
	
	/**
	 * add new word
	 */
	public abstract boolean addWord(String word);
	/**
	 * Word according to dictionary?
	 */
	public abstract boolean isWord(String word);
	/**
	 * return number of words
	 */
	public abstract int size();
	/**
	 * load dictionary from file
	 */
	public abstract boolean loadDictionary(String file);
}
