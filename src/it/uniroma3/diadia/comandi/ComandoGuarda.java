package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoGuarda implements Comando {
	private IO io;
	private final static String NOME = "guarda";
	
	@Override 
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		
		io.mostraMessaggio("Hai ancora: " +partita.getGiocatore().getCfu()+ "CFU");
		
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		
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
	
	@Override 
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override 
	public String NOME(){
		return NOME;
	}
	

}
