package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagica extends Stanza{
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private static final int SOGLIA_MAGICA_DEFAULT = 3;

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int n) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = n;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.contatoreAttrezziPosati > this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
		}
		this.contatoreAttrezziPosati++;
		return super.addAttrezzo(attrezzo);
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
		int pesoDoppio = attrezzo.getPeso()*2;

		nomeInvertito = nomeInvertito.reverse();

		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoDoppio);

		return attrezzo;
	}

}
