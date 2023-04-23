package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoFine implements Comando {
	private IO io;
	private final static String NOME = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";

	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE);
	}
	
	@Override 
	public void setParametro(String parametro) {
		//TODO Auto-generated method stub
	}
	
	@Override
	public String getParametro() {
		//TODO Auto-generated method stub
		return null;
	}
	
	public void setIO(IO io) {
		this.io = io;
	}
	
	public String NOME() {
		return NOME;
	}
}
