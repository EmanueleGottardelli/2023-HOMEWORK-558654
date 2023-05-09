package diadia.ambienti;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaMagica;

public class StanzaMagicaTest {

	private StanzaMagica sm;
	private Attrezzo p;
	private Attrezzo m;
	private Attrezzo b;
	
	@Before
	public void setUp() throws Exception {
		sm = new StanzaMagica("sm",2);
		p = new Attrezzo("pennello", 2);
		m = new Attrezzo("mestolo", 3);
		b = new Attrezzo("bottiglia", 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(sm.addAttrezzo(m));

	}


	@Test
	public void testModificaAttrezzo() {
		assertTrue(sm.addAttrezzo(p));
		assertTrue(sm.addAttrezzo(b));
		assertTrue(sm.addAttrezzo(m));

		//assertEquals("olotsem",m.getNome());	
		//assertEquals(6,m.getPeso());	

		}
}

