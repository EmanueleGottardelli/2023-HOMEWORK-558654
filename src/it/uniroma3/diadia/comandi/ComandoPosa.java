package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.*;

public class ComandoPosa implements Comando {
	private IO io;
	private String nomeAttrezzo; 
	private final static String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(partita.getLabirinto().getStanzaCorrente().getNumeroAttrezziPossibili() > 0) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		}
		else {
			io.mostraMessaggio("Non c'è spazio nella stanza per posare l'attrezzo!");
		}
	}

	@Override 
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

	@Override 
	public String getParametro() {
		return this.nomeAttrezzo;

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
