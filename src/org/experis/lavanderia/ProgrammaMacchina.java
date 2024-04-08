package org.experis.lavanderia;

public abstract class ProgrammaMacchina {
	private int numero;
	
	private int gettoni;
	
	private int durata;
	
	private String nome;

	public ProgrammaMacchina(int numero, int gettoni, int durata, String nome) {
		this.numero = numero;
		this.gettoni = gettoni;
		this.durata = durata;
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public int getGettoni() {
		return gettoni;
	}

	public int getDurata() {
		return durata;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "ProgrammaMacchina [numero=" + numero + ", gettoni=" + gettoni + ", durata=" + durata + ", nome=" + nome
				+ "]";
	}
	
}
