package diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

import org.junit.Test;
import org.junit.Before;

public class PartitaTest {
	private Labirinto labirinto;
	private Partita p;
	private Stanza s;
	
	
	@Before
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("gessetto",1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		p = new Partita(labirinto);
		s = new Stanza("stanza");
	}
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testIsFinita() {
		assertFalse(p.isFinita());
	}
}