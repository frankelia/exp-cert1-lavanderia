package org.experis.lavanderia;

import org.experis.lavanderia.exceptions.LavanderiaException;

public class Lavatrice extends Macchina {

	private Serbatoio detersivo; 
	
	private Serbatoio ammorbidente;

	public Lavatrice(int numero, int numeroGettoni, boolean sportelloAperto, int quantitaDetersivo, int quantitaAmmorbidente) {
		super(numero, numeroGettoni, sportelloAperto);
		detersivo = new Serbatoio(1000, quantitaDetersivo);
		ammorbidente = new Serbatoio(500, quantitaAmmorbidente);
		
		programmi.add(new ProgrammaLavatrice(1, 5, 20, "Rinfrescante", 25, 20));
		programmi.add(new ProgrammaLavatrice(2, 10, 40, "Rinnovante", 50, 40));
		programmi.add(new ProgrammaLavatrice(3, 15, 60, "Sgrassante", 100, 60));
	}
	
	public Lavatrice(int numero, int numeroGettoni, boolean sportelloAperto) {
		this(numero, numeroGettoni, sportelloAperto, 0, 0);
	}

	public void addDetersivo(int quantita) throws LavanderiaException {
		this.detersivo.aggiungi(quantita);
	}
	
	@Override
	public void setInFunzione(boolean inFunzione) throws LavanderiaException {
		super.setInFunzione(inFunzione);
		
		boolean gettoniOk = this.inFunzione;
		if (!gettoniOk) return;
		
		ProgrammaLavatrice p = (ProgrammaLavatrice)getProgrammaSelezionato();
		if (p.getConsumoDetersivo() > detersivo.getContenuto()) {
			this.inFunzione = false;
			this.addGettoni(p.getGettoni());
			throw new LavanderiaException("Detersivo non sufficiente");
		}
	}
	
	public Serbatoio getDetersivo() {
		return detersivo;
	}
	
	public Serbatoio getAmmorbidente() {
		return ammorbidente;
	}

	@Override
	public String toString() {
		return super.toString() + " [detersivo=" + detersivo + ", ammorbidente=" + ammorbidente + "]";
	}

	

	
}
