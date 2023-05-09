package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private static final int SOGLIA_MAGICA_DEFAULT = 3;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int n) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = n;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezziStanza.put(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		else if (this.contatoreAttrezziPosati < this.sogliaMagica) { 
			attrezzo = this.modificaAttrezzo(attrezzo);
		this.contatoreAttrezziPosati++;
		return true;
		}
		return false;
	}

	private Attrezzo modificaAttrezzo(Attrezzo a) {
		StringBuilder nomeInvertito;
		int pesoDoppio = a.getPeso()*2;

		nomeInvertito = new StringBuilder(a.getNome());
		nomeInvertito = nomeInvertito.reverse();

		a = new Attrezzo(nomeInvertito.toString(), pesoDoppio);

		return a;
	}
}
