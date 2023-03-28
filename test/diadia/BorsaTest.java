package diadia;

import static org.junit.Assert.*;

import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Test;

import org.junit.Before;

public class BorsaTest {
	
	Borsa b = new Borsa();
	Attrezzo c;
	Attrezzo m;
	
	@Before
	public void setUp() {
		c = new Attrezzo("Computer", 20);
		m = new Attrezzo("Mouse", 1);
	}
	
	@Test
	public void testAddAttrezzoPesoMaggiore10() {
		assertFalse(b.addAttrezzo(c));
	}

	@Test
	public void testAddAttrezzoPesoMinore10() {
		assertTrue(b.addAttrezzo(m));
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, b.getPesoMax());
	}

}
