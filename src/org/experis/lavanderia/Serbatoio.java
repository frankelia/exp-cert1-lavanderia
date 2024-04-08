package org.experis.lavanderia;

import org.experis.lavanderia.exceptions.LavanderiaException;

public class Serbatoio {
	private int capacita;

	private int contenuto;
	
	public Serbatoio(int capacita) {
		this.capacita = capacita;
		this.contenuto = 0;
	}
	
	public Serbatoio(int capacita, int contenuto) {
		this.capacita = capacita;
		this.contenuto = contenuto;
	}
	
	public int getContenuto() {
		return contenuto;
	}
	
	public int getCapacita() {
		return capacita;
	}

	@Override
	public String toString() {
		return "Serbatoio [capacita=" + capacita + ", contenuto=" + contenuto + "]";
	}

	public void aggiungi(int quantita) throws LavanderiaException {
		if (this.contenuto + quantita > capacita) {
			throw new LavanderiaException("Non puoi aggiungere più materiale");
		}
		
		this.contenuto += quantita;
	}
	
}
