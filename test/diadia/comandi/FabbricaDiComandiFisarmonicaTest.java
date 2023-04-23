package diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.comandi.*;


public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica fabbrica;
	private IOconsole io;
	private Comando expected;
	
	@Before
	public void setUp() throws Exception {
		io = new IOconsole();
		fabbrica = new FabbricaDiComandiFisarmonica(io);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCostruisciComandoNonValido() {
		expected = new ComandoNonValido();
		assertEquals(expected.NOME(), fabbrica.costruisciComando("pluto").NOME());
	}
	
	@Test
	public void testCostruisciComandoVai() {
		expected = new ComandoVai();
		expected.setParametro("sud");
		
		Comando current = fabbrica.costruisciComando("vai sud");
		
		assertEquals(expected.NOME(), current.NOME());
		assertEquals(expected.getParametro(), current.getParametro());
	}
	
	@Test
	public void testCostruisciComandoPrendi() {
		expected = new ComandoPrendi();
		expected.setParametro("osso");
		
		Comando current = fabbrica.costruisciComando("prendi osso");
		
		assertEquals(expected.NOME(), current.NOME());
		assertEquals(expected.getParametro(), current.getParametro());
		
	}
	
	@Test
	public void testCostruisciComandoPosa() {
		expected = new ComandoPosa();
		expected.setParametro("ascia");
		
		Comando current = fabbrica.costruisciComando("posa ascia");
		
		assertEquals(expected.NOME(), current.NOME());
		assertEquals(expected.getParametro(), current.getParametro());
		
	}
	
	
	@Test
	public void testCostruisciComandoSenzaParametro() {
		expected = new ComandoFine();
		
		Comando current = fabbrica.costruisciComando("fine");
		
		assertEquals(expected.NOME(), current.NOME());		
	}

}
