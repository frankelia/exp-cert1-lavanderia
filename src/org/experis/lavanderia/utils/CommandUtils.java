package org.experis.lavanderia.utils;

import org.experis.lavanderia.Comando;
import org.experis.lavanderia.Lavatrice;
import org.experis.lavanderia.Macchina;
import org.experis.lavanderia.exceptions.LavanderiaException;

public class CommandUtils {
	private CommandUtils() {
	}
	
	public static void apriSportello(Macchina m) throws LavanderiaException {
		m.setSportelloAperto(true);
	}
	
	public static void chiudiSportello(Macchina m) throws LavanderiaException {
		m.setSportelloAperto(false);
	}
	
	public static void addGettoni(Macchina m, Integer numeroGettoni) throws LavanderiaException {
		m.addGettoni(numeroGettoni);
	}
	
	public static void selezionaProgramma(Macchina m, int programma) throws LavanderiaException {
		m.setProgramma(programma);
	}
	
	public static void avvia(Macchina m) throws LavanderiaException {
		m.setInFunzione(true);
	}
	
	public static void ferma(Macchina m) throws LavanderiaException {
		m.setInFunzione(false);
	}
	
	public static void aggiungiDetersivo(Lavatrice l, int quantita) throws LavanderiaException {
		l.addDetersivo(quantita);
	}
	
	public static void listaProgrammi(Macchina m) {
		m.getProgrammi().forEach(programma -> {
			System.out.println(programma);
		});
	}
	
	public static Comando parsaComando(String command) {
		String[] parti = command.split(" ");
		if (parti.length < 2)
			throw new IllegalArgumentException("Invalid command: " + command + "; at least 2 arguments");
		
		String nomeComando = parti[0];
		int numeroMacchina = Integer.parseInt(parti[1]);
		
		Integer parametroAggiuntivo = null;
		if (parti.length == 3) {
			parametroAggiuntivo = Integer.parseInt(parti[2]);
		}

		return new Comando(nomeComando, numeroMacchina, parametroAggiuntivo);
	}

}
