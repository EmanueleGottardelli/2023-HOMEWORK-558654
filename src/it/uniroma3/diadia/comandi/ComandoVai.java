package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;

public class ComandoVai implements Comando {
	
	private String direzione;
	private IO io;
	private final static String NOME = "vai";

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.direzione == null) {
			this.io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione!");
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;

	}
	
	@Override
	public String NOME() {
		return NOME;
	}

}