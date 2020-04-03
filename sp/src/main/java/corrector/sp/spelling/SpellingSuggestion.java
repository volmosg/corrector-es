package corrector.sp.spelling;

import java.util.List;

public interface SpellingSuggestion {
	
	// TODO implement differently depending on the case?
	// TODO implement nearbyWords by 1-distance transformations?
	// think of different kind of errors?
	public List<String> suggestions(String word, int numSuggestions);

}
