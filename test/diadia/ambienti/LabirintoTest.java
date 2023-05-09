package diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import it.uniroma3.diadia.ambienti.*;

public class LabirintoTest {
	Labirinto l;
	Stanza sc;
	
	@Before
	public void setUp() {
		l = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		
		sc = new Stanza("sc");
		
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(sc);
		assertEquals("sc", l.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}

}
