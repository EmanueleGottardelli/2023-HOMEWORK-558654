package diadia.comandi;

import static org.junit.Assert.*;

import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ComandoPosaTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Comando comando;

	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		attrezzo = new Attrezzo("martello", 2);
		comando = new ComandoPosa();
		comando.setIO(new IOconsole());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}

	@Test
	public void testAttrezzoPosatoNull() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}


	public void creatoreAttrezzi() {
		for(int i= 0; i<10;i++) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("utensile"+i, 1));
		}
	}

	@Test
	public void testTroppiAttrezzi() {
		this.creatoreAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}



}
