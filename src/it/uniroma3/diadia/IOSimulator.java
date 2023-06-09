package it.uniroma3.diadia;

import java.util.List;
import java.util.ArrayList;

public class IOSimulator implements IO{
	private List<String> righeLette;
	private int indiceRigheLette;
	
	private List<String> messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indiceRigheLette = 0;
		this.indiceMessaggiMostrati = 0;
		this.messaggiProdotti = new ArrayList<String>();		
	}
	
	public List<String> getMessaggiProdotti(){
		return messaggiProdotti;
	}
	
	public void setMessaggiProdotti(List<String> messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti.add(this.indiceMessaggiProdotti,msg);
		this.indiceMessaggiProdotti++;
	}
	
	@Override
	public String leggiRiga() {
		String riga = null;
		
		riga = this.righeLette.get(indiceRigheLette);
		this.indiceRigheLette++;
		return riga;
	}
	
	public String nextMessage(String msg) {
		String rigaNext = this.messaggiProdotti.get(indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return rigaNext;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}

}

