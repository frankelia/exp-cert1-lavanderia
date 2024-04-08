package org.experis.lavanderia;

public class Asciugatrice extends Macchina {

	public Asciugatrice(int numero, int numeroGettoni, boolean sportelloAperto) {
		super(numero, numeroGettoni, sportelloAperto);
		
		programmi.add(new ProgrammaAsciugatrice(1, 2, 20, "Rapido"));
		programmi.add(new ProgrammaAsciugatrice(2, 4, 60, "Intenso"));
	}

	

}
