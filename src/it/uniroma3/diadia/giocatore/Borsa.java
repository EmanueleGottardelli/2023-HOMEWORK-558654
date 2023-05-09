package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class Borsa{
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezziBorsa;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezziBorsa = new TreeMap<>();
		this.numeroAttrezzi = 0;
		this.pesoAttuale = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso() + attrezzo.getPeso() > this.pesoMax)
			return false;
		this.attrezziBorsa.put(attrezzo.getNome(), attrezzo);
		this.pesoAttuale += attrezzo.getPeso();
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax(){
		return pesoMax;
	}
	
	public void setPesoMax(int pesoMax){
		this.pesoMax = pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo != null && this.attrezziBorsa.containsKey(nomeAttrezzo)) {
			a = this.attrezziBorsa.get(nomeAttrezzo);
			return a;
		}
		return null;
	}

	public int getPeso() {
		return this.pesoAttuale;
	}
	
	public boolean getPesoRimanente(Attrezzo a) {
		if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
			return true;
		return false; 
	}

	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo!=null){
			a = attrezziBorsa.remove(nomeAttrezzo);
		}
		return a;

	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> a = new ArrayList<>();
		a.addAll(this.attrezziBorsa.values());
		Collections.sort(a, new ComparatoreAttrezziPerPeso());
		
		return a;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.attrezziBorsa.values());
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> am = new TreeMap<>();
		for(Attrezzo a : this.attrezziBorsa.values()) {
			if(am.containsKey(a.getPeso())) {
				am.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> ahs = new HashSet<Attrezzo>();
				ahs.add(a);
				am.put(a.getPeso(), ahs);
			}
		}
		return am;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		s.addAll(this.attrezziBorsa.values());
		return s;
	}

	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
				s.append("\n");
				
			s.append(this.getContenutoOrdinatoPerPeso().toString());
				s.append("\n");
				
			s.append(this.getContenutoOrdinatoPerNome().toString());
				s.append("\n");
				
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
				s.append("\n");
				
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}