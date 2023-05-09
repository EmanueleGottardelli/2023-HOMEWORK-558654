package diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;

public class LabirintoBuilderTest {
	LabirintoBuilder lb;

	@Before
	public void setUp() throws Exception {
		lb = new LabirintoBuilder();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getLabirintoTest() {
		assertNotNull(lb.getLabirinto());
		assertEquals(Labirinto.class, lb.getLabirinto().getClass());
	}
	
	@Test
	public void addStanzaInizialeTest() {
		lb.addStanzaIniziale("atrio");
		Stanza i = new Stanza("atrio");
		assertEquals(i, lb.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void addStanzaVincenteTest() {
		lb.addStanzaVincente("biblioteca");
		Stanza v = new Stanza("biblioteca");
		assertEquals(v, lb.getLabirinto().getStanzaVincente());
	}
	
	@Test
	public void addAttrezzoSenzaStanzaUltima() {
		lb.addAttrezzo("manubrio", 5);		
		assertEquals(LabirintoBuilder.class, lb.addAttrezzo("manubrio", 5).getClass());
	}
	
	@Test
	public void addAttrezzoConUltimaStanza() {
		lb.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		Attrezzo expected = new Attrezzo("cacciavite", 3);
		assertEquals(expected, lb.getLabirinto().getStanzaCorrente().getAttrezzo("cacciavite"));		

	}
	
	@Test
	public void addAttrezzoStanza() {
		lb.addStanza("stanza");
		lb.addAttrezzo("forbice",1);
		
		assertTrue(lb.getNomeStanza().get("stanza").hasAttrezzo("forbice"));

	}

}
