package org.experis.lavanderia;

public class ProgrammaLavatrice extends ProgrammaMacchina {

	private final int consumoDetersivo;
	
	private final int consumoAmmorbidente;
	
	public ProgrammaLavatrice(int numero, int gettoni, int durata, 
			String nome, int consumoDetersivo, int consumoAmmorbidente) {
		super(numero, gettoni, durata, nome);
		this.consumoAmmorbidente = consumoAmmorbidente;
		this.consumoDetersivo = consumoDetersivo;
	}

	public int getConsumoDetersivo() {
		return consumoDetersivo;
	}

	public int getConsumoAmmorbidente() {
		return consumoAmmorbidente;
	}

	@Override
	public String toString() {
		return super.toString() + " [consumoDetersivo=" + consumoDetersivo + ", consumoAmmorbidente="
				+ consumoAmmorbidente + "]";
	}
	
	
	
}
