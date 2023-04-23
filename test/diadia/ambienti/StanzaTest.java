package diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Stanza s1 = new Stanza("s1");
	Stanza s2 = new Stanza("s2");
	Attrezzo a = new Attrezzo("Computer", 20);
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("sud", s2);
		assertEquals(s2, s1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(s1.addAttrezzo(a));
	}
	
}
