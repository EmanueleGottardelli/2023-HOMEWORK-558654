package diadia.comandi;

import static org.junit.Assert.*;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class ComandoPrendiTest {
	private Stanza s;
	private Attrezzo a1;
	private Attrezzo a2;
	private ComandoPrendi prendi;
	private Partita p;
	Labirinto labirinto;
	
	@Before 
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("forbice", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "sud")
				.getLabirinto();
		p = new Partita(labirinto);
		s = new Stanza("aula1");
		a1 = new Attrezzo("osso", 1);
		a2 = new Attrezzo("pneumatico", 15);
		prendi = new ComandoPrendi();
		prendi.setIO(new IOconsole());
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	public boolean attrezzoPresente(String s) {		
		if(p.getStanzaCorrente().getAttrezzo(s) == null)
					return false;
		return true;
	}

	
	@Test
	public void setParametroTest() {
		prendi.setParametro("telecomando");
		assertEquals("telecomando", prendi.getParametro());
	}
	
	@Test
	public void testAttrezzoPreso() {
		p.getLabirinto().setStanzaCorrente(s);
		p.getLabirinto().getStanzaCorrente().addAttrezzo(a1);
		prendi.setParametro("osso");
		prendi.esegui(p);
		assertFalse(attrezzoPresente("osso"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		p.getLabirinto().setStanzaCorrente(s);
		p.getLabirinto().getStanzaCorrente().addAttrezzo(a2);
		prendi.setParametro("pneumatico");
		prendi.esegui(p);
		
		assertTrue(attrezzoPresente("pneumatico"));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		p.getLabirinto().setStanzaCorrente(s);
		prendi.setParametro("osso");
		prendi.esegui(p);
		
		assertFalse(attrezzoPresente("osso"));
	}

	

}
