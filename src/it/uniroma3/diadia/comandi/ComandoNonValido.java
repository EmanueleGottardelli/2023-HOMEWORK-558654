package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoNonValido implements Comando{
	private IO io;
	private final static String NOME = "non valido"; 
	
	@Override 
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido!");
	}
	
	@Override 
	public void setParametro(String Parametro) {
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
	public String NOME() {
		return NOME;
	}
	

}
