package diadia;

import static org.junit.Assert.*;

import it.uniroma3.diadia.giocatore.*;

import org.junit.Test;

public class GiocatoreTest {
	Giocatore g = new Giocatore();
	
	@Test
	public void testGetCfu() {
		assertEquals(20, g.getCfu());
	}

	@Test
	public void testSetCfu() {
		g.setCfu(9);
		assertEquals(9, g.getCfu());
	}

	@Test
	public void testGetBorsa() {
		assertNotNull(g.getBorsa());
	}

}
