package diadia.ambienti;

import static org.junit.Assert.*;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class StanzaBloccataTest {
	private StanzaBloccata sb; //STANZA BLOCCATA
	private Attrezzo chiave;
	private Stanza s1;
	
	@Before
	public void setUp() throws Exception{
		s1 = new Stanza("Stanza");
		sb = new StanzaBloccata("Stanza Bloccata", "ovest", "chiave");
		chiave = new Attrezzo("chiave", 1);
		sb.impostaStanzaAdiacente("ovest", s1);
	}

	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb, sb.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteAttrezzoSbloccante() {
		sb.addAttrezzo(chiave);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetStanzaAdiacenteSenzaAttrezzoSbloccante() {
		String bloccata = "Stanza bloccata nella direzione: ovest"+"\nPrendi chiave poi posalo nella stanza!";
		assertEquals(bloccata, sb.getDescrizione());
	}
}

