package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> nomeStanza;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nomeStanza = new HashMap<String, Stanza>();
	}
	
	public Map<String, Stanza> getNomeStanza(){
		return this.nomeStanza;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza s = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaCorrente(s);
		this.ultimaStanzaAggiuntaEAggiornata(s);
		
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int pesoAttrezzo) {
		Attrezzo a = new Attrezzo(nomeAttrezzo, pesoAttrezzo);
		if(this.ultimaStanzaAggiunta == null)
			return this;
		this.ultimaStanzaAggiunta.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza sv = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(sv);
		this.ultimaStanzaAggiuntaEAggiornata(sv);
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.ultimaStanzaAggiuntaEAggiornata(s);;
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
		Stanza s1 = this.nomeStanza.get(stanzaCorrente);
		Stanza s2 = this.nomeStanza.get(stanzaAdiacente);
		
		s1.impostaStanzaAdiacente(direzione, s2);
		
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String attrezzoSbloccante, String direzione) {
		Stanza sb = new StanzaBloccata(nomeStanza, attrezzoSbloccante, direzione);
		this.ultimaStanzaAggiuntaEAggiornata(sb);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int sogliaMagica) {
		Stanza sm = new StanzaMagica(nomeStanza, sogliaMagica);
		this.ultimaStanzaAggiuntaEAggiornata(sm);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String attrezzoIlluminante) {
		Stanza sb = new StanzaBuia(nomeStanza, attrezzoIlluminante);
		this.ultimaStanzaAggiuntaEAggiornata(sb);
		return this;
	}
	
	public void ultimaStanzaAggiuntaEAggiornata(Stanza ultimaStanza) {
		this.ultimaStanzaAggiunta = ultimaStanza;
		this.nomeStanza.put(ultimaStanza.getNome(), ultimaStanza);
	}

}
