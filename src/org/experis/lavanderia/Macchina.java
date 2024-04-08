package org.experis.lavanderia;

import java.util.ArrayList;
import java.util.List;

import org.experis.lavanderia.exceptions.LavanderiaException;

public abstract class Macchina {
	private int numero;
	
	protected boolean sportelloAperto;
	
	protected boolean inFunzione;
	
	protected int numeroGettoni;
	
	protected List<ProgrammaMacchina> programmi = new ArrayList<>();
	
	protected Integer programma;
	
	public Macchina(int numero, int numeroGettoni, boolean sportelloAperto) {
		this.numero = numero;
		this.numeroGettoni = numeroGettoni;
		this.sportelloAperto = sportelloAperto;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public boolean isSportelloAperto() {
		return sportelloAperto;
	}
	
	public int getNumeroGettoni() {
		return numeroGettoni;
	}
	
	public boolean isInFunzione() {
		return inFunzione;
	}
	
	public ProgrammaMacchina getProgrammaSelezionato() {
		return programmi.get(programma - 1);
	}
	
	public void setInFunzione(boolean inFunzione) throws LavanderiaException {
		if (programma == null) {
			throw new LavanderiaException("Nessun programma selezionato");
		}
		
		if (getProgrammaSelezionato().getGettoni() > getNumeroGettoni()) {
			throw new LavanderiaException("Gettoni non sufficienti");
		}
		
		this.numeroGettoni -= getProgrammaSelezionato().getGettoni();
		this.inFunzione = inFunzione;
	}
	
	public int getProgramma() {
		return programma;
	}
	
	public void setProgramma(int programma) throws LavanderiaException {
		if (programma < 1 || programma >= programmi.size())
			throw new LavanderiaException("Programma " + programma + " non trovato.");
		
		this.programma = programma;
	}
	
	public void setSportelloAperto(boolean sportelloAperto) throws LavanderiaException {
		if (this.sportelloAperto && sportelloAperto) {
			throw new LavanderiaException("Lo sportello della macchina " + getNumero()
					+ " è già aperto");
		}
		
		if (!this.sportelloAperto && !sportelloAperto) {
			throw new LavanderiaException("Lo sportello della macchina " + getNumero()
					+ " è già chiuso");
		}
		this.sportelloAperto = sportelloAperto;
	}
	
	public void addGettoni(Integer n) throws LavanderiaException {
		if (n == null || n <= 0) {
			throw new LavanderiaException("Non puoi aggiungere un numero di gettoni negativo");
		}
		this.numeroGettoni += n;
	}
	
	public List<ProgrammaMacchina> getProgrammi() {
		return programmi;
	}

	@Override
	public String toString() {
		return "[numero=" + numero + ", sportelloAperto=" + sportelloAperto + ", inFunzione=" + inFunzione
				+ ", numeroGettoni=" + numeroGettoni + ", programma=" + programma + "]";
	}

	
	
}
