package org.experis.lavanderia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lavanderia {
	private static final Random random = new Random();
	
	private List<Macchina> macchine = new ArrayList<>();
	
	private String esitoOperazione;
	
	public Lavanderia(int numLavatrici, int numAsciugatrici) {
		int id = 0;
		for ( ; id < numLavatrici; id++) {
			macchine.add(
				new Lavatrice(
					id + 1, 
					random.nextInt(0, 16), 
					random.nextBoolean(), 
					random.nextInt(0, 10), 
					random.nextInt(0, 10)
				)
			);
		}
		
		for ( ; id < numLavatrici + numAsciugatrici; id++) {
			macchine.add(
				new Asciugatrice(
					id + 1, 
					random.nextInt(0, 16), 
					random.nextBoolean()
				)
			);
		}
	}

	public List<Macchina> getMacchine() {
		return macchine;
	}
	
	public String getEsitoOperazione() {
		return esitoOperazione;
	}
	
	public void setEsitoOperazione(String esitoOperazione) {
		this.esitoOperazione = esitoOperazione;
	}
	
	
	public void stampaStato() {
		System.out.println("============================= STATO LAVANDERIA ==============================");
		System.out.println("Tipo macchina\tNumero\tSportello\tGettoni\tDetersivo\tAmmorbidente");
		for (Macchina macchina : macchine) {
			System.out.println(macchina);
		}
		System.out.println("=============================================================================");
	}
	
	public void stampaComandi() {
		System.out.println("apri         apre lo sportello   															-   \n"
				+ "chiudi       chiude lo sportello 															-   \n"
				+ "gettoni      inserisce il numero di gettoni nella macchina specificata 			            numero di gettoni positivo e maggiore di 0");
	}
	
	
}
