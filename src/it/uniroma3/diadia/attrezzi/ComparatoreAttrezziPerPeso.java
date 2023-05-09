package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo>{
	
	public int compare(Attrezzo at1, Attrezzo at2) {
		if(at1.getPeso() - at2.getPeso() == 0)
			return at1.getNome().compareTo(at2.getNome());
		
		return at1.getPeso()-at2.getPeso();
	}
}
