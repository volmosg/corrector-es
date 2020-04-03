package corrector.sp.document;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Document {
	
	private String text;
	private int numWords;
	//syllables?
	//paragraphs?
	
	public Document(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	// tokenizer
	public List<String> getTokens() {
		List<String> tokens = new LinkedList<String>();
		// naive pattern for tokens
		//TODO check if it works for Spanish
		// \p{L} works with accentuated characters
		String pattern = "[!?.,¿¡]+|\\p{L}+";
		Pattern tokenizer = Pattern.compile(pattern);
		Matcher matcher = tokenizer.matcher(text);
		
		while (matcher.find()) {
			tokens.add(matcher.group());
		}
		return tokens;
		
	}
	
	public List<String> getTrigrams() {
		
		List<String> trigrams = new LinkedList<String>();
		StringBuffer sb = new StringBuffer();
		List<String> words = new LinkedList<String>();
		
		// preselect words
		for (String token : getTokens()) {
			if (isWord(token)) {
				words.add(token);
			}
		}
		
		// TODO fix bug with end of sentence
		for (int i = 0; i < words.size() - 2; i++) {
			trigrams.add(words.get(i) + " " + words.get(i + 1) + " " + words.get(i + 2));
		}
		
		
		return trigrams;
		
	}
	
	public boolean isWord(String token) {
		return !(token.indexOf("!") >=0 || token.indexOf(".") >=0 || token.indexOf("?")>=0 || token.indexOf(",")>=0 || token.indexOf("¿")>=0 || token.indexOf("¡")>=0);
	}

}
