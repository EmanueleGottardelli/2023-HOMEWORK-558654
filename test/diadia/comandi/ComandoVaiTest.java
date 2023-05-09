package diadia.comandi;

import static org.junit.Assert.*;


import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.*;

import org.junit.Before;
import org.junit.Test;


public class ComandoVaiTest {
	private Stanza s1;
	private Stanza s2;
	private ComandoVai vai;
	private Partita p;
	Labirinto labirinto;
	
	@Before 
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("chiave", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		s1 = new Stanza("aula1");
		s2 = new Stanza("aula2");
		vai = new ComandoVai();
		p = new Partita(labirinto);
		vai.setIO(new IOconsole());
	}

	@Test
	public void testSetParametro() {
		vai.setParametro("nord");
		assertEquals("nord", vai.getParametro());
	}
	
	@Test
	public void testEseguiNull() {
		p.getLabirinto().setStanzaCorrente(s1);
		vai.esegui(p);
		
		assertEquals(s1, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testEseguiDirezioneEsistente() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		vai.setParametro("sud");
		vai.esegui(p);
		
		assertNotEquals(s2, p.getLabirinto().getStanzaCorrente());
		}
	
	@Test
	public void testEseguiDirezuoneEsistenteGiusta() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("ovest", s2);
		vai.setParametro("ovest");
		vai.esegui(p);
		
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}

}
