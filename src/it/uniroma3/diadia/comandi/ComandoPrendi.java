package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi implements Comando{
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		}
		else {
			io.mostraMessaggio("Non c'è spazio per aggiungere l'attrezzo alla borsa!");
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
	
	public void setIO(IO io) {
		this.io = io;
	}
	
	public String NOME() {
		return NOME;
	}
	

}
