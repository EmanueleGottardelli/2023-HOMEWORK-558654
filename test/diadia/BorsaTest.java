package diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;
import org.junit.Before;

public class BorsaTest {
	
	Borsa b;
	Borsa b1;
	Borsa b2;
	Attrezzo piuma;
	Attrezzo piombo;
	Attrezzo libro;
	Attrezzo ps;
	Attrezzo incudine;
	
	
	@Before
	public void setUp() {
		b = new Borsa();
		b1 = new Borsa();
		b2 = new Borsa();
		
		
		
		incudine = new Attrezzo("incudine", 25);
		piuma = new Attrezzo("piuma",1);
		piombo = new Attrezzo("piombo", 10);
		ps = new Attrezzo("ps", 5);
		libro = new Attrezzo("libro", 5);
	}
	
	@Test
	public void testSetPesoMax() {
		b2.setPesoMax(22);
		assertEquals(22, b2.getPesoMax());
	}
	
	@Test
	public void testAddAttrezzoPesoMaggiore10() {
		assertFalse(b.addAttrezzo(incudine));
	}

	@Test
	public void testAddAttrezzoPesoMinore10() {
		assertTrue(b.addAttrezzo(piuma));
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, b.getPesoMax());
	}
	
	@Test
	public void testGetSortedPerPesoStessoPesoNomeDiverso() {
		b1.addAttrezzo(libro);
		b1.addAttrezzo(ps);
		
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		
		expected.add(libro);
		expected.add(ps);
		
		assertArrayEquals(expected.toArray(), b1.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	public boolean controllaSet(Set<Attrezzo> m1, Set<Attrezzo> m2) {
		if(m1.size()!=m2.size())
			return false;
		Iterator<Attrezzo> iter1 = m1.iterator();
		Iterator<Attrezzo> iter2 = m2.iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!iter1.next().equals(iter2.next()))
				return false;
		}
		return true;
	}
	
	public boolean controllaMap(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controllaSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiGruppi() {
		
		b2.setPesoMax(22);
		
		b2.addAttrezzo(piuma);
		b2.addAttrezzo(piombo);
		b2.addAttrezzo(ps);
		b2.addAttrezzo(libro);

		Map<Integer, Set<Attrezzo>> expected = new TreeMap<>();
		Set<Attrezzo> hs1 = new HashSet<>();
		Set<Attrezzo> hs2 = new HashSet<>();
		Set<Attrezzo> hs3 = new HashSet<>();
		
		hs1.add(piuma);
		hs2.add(ps);
		hs2.add(libro);
		hs3.add(piombo);
		
		expected.put(1, hs1);
		expected.put(5, hs2);
		expected.put(10, hs3);
		
		System.out.println(expected);
		System.out.println(b2.getContenutoRaggruppatoPerPeso());
		assertTrue(this.controllaMap(expected, b2.getContenutoRaggruppatoPerPeso()));
		
		}

}
