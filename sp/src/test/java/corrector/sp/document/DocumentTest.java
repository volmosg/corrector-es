package corrector.sp.document;

import java.util.ArrayList;
import java.util.List;

import corrector.sp.document.Document;
import junit.framework.TestCase;

public class DocumentTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testGetTokens() {
		Document text1 = new Document("hola, caracola");
		List<String> tokens1 = new ArrayList<String>();
		
		tokens1 = text1.getTokens();
		assertEquals(tokens1.size(), 3);
		assertEquals(tokens1.get(1), (","));
		
		Document text2 = new Document("El veloz murciélago hindú");
		List<String> tokens2 = text2.getTokens();
		assertEquals(tokens2.size(), 4);
		assertEquals(tokens2.get(2), "murciélago");
		
		Document text3 = new Document("El ñandú comía trigo");
		List<String> tokens3 = text3.getTokens();
		assertEquals(tokens3.size(), 4);
		assertEquals(tokens3.get(1), "ñandú");
	}
	
	public void testIsWord() {
		Document text = new Document("document");
		
		assertFalse(text.isWord("!"));
		assertFalse(text.isWord("¡"));
		assertFalse(text.isWord(","));
		assertFalse(text.isWord("¿"));
		assertFalse(text.isWord("."));
		
		assertTrue(text.isWord("El"));
		assertTrue(text.isWord("ñandú"));
	}
	
	public void testGetTrigrams() {
		Document text = new Document("La gramática del español es muy similar a la de las demás lenguas romances. El español es una lengua flexiva de tipo fusionante, es decir, en las oraciones se usa preferentemente la flexión para indicar las relaciones entre sus elementos.");
		List<String> trigrams = text.getTrigrams();
		
		assertEquals(trigrams.size(), 38);
		
		
		// for debugging
		for (String trigram : trigrams) {
			System.out.println(trigram);
		}
		
		
	}

}
