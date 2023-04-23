package diadia.ambienti;

import static org.junit.Assert.*;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class StanzaBuiaTest {
	private StanzaBuia sb; //STANZA BUIA
	private Attrezzo torcia;
	
	
	@Before
	public void setUp()throws Exception{
		sb = new StanzaBuia("Stanza Buia", "torcia");
		torcia = new Attrezzo("torcia", 1);
	}
	
	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void testDescrizioneConAttrezzo() {
		sb.addAttrezzo(torcia);
		assertEquals(sb.toString(),sb.getDescrizione());
	}
	
	@Test
	public void testDescrizioneSenzaAttrezzo() {
		String buio = new String();
		buio = "qui c'è un buio pesto!";
		
		assertEquals(buio, sb.getDescrizione());
	}

}
