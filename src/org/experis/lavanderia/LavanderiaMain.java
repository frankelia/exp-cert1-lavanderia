package org.experis.lavanderia;

import java.util.Scanner;

import org.experis.lavanderia.exceptions.LavanderiaException;
import org.experis.lavanderia.utils.CommandUtils;

public class LavanderiaMain {
	public static void main(String[] args) {
		Lavanderia lavanderia = new Lavanderia(3, 2);
		Scanner scanner = new Scanner(System.in);
		
		String comandoUtente = "";
		
		while (!comandoUtente.equalsIgnoreCase("esci")) {
			lavanderia.stampaStato();
			
			if (lavanderia.getEsitoOperazione() != null) {
				System.out.println(lavanderia.getEsitoOperazione());
			} else {
				System.out.println("Nessuna operazione effettuata.");
			}
			System.out.println("=============================================================================");
			lavanderia.stampaComandi();
			System.out.println("=============================================================================\n");
			System.out.print("> ");
			comandoUtente = scanner.nextLine();
			
			try {
				Comando comando = CommandUtils.parsaComando(comandoUtente);
				// Trovo la macchina con il ciclo for
	//			Macchina macchina1 = null;
	//			for (Macchina m : lavanderia.getMacchine()) {
	//				if (m.getNumero() == comando.getNumeroMacchina()) {
	//					macchina1 = m;
	//				}
	//			}
				
				// Trovo la macchina con gli stream
				Macchina macchina = lavanderia.getMacchine().stream()
					.filter(m -> m.getNumero() == comando.getNumeroMacchina())
					.findFirst()
					.orElse(null);
	
				if (macchina == null) {
					throw new LavanderiaException("Macchina non valida");
				}
				
				if (comando.getNome().equalsIgnoreCase("apri")) {
					CommandUtils.apriSportello(macchina);
					lavanderia.setEsitoOperazione("Sportello aperto");
				} else if (comando.getNome().equalsIgnoreCase("chiudi")) {
					CommandUtils.chiudiSportello(macchina);
					lavanderia.setEsitoOperazione("Sportello chiuso");
				} else if (comando.getNome().equalsIgnoreCase("gettoni")) {
					CommandUtils.addGettoni(macchina, comando.getParametroAggiuntivo());
					lavanderia.setEsitoOperazione("Gettoni aggiunti");
				} else if (comando.getNome().equalsIgnoreCase("lista")) {
					CommandUtils.listaProgrammi(macchina);
					lavanderia.setEsitoOperazione(null);
				} else  if (comando.getNome().equalsIgnoreCase("programma")) {
					CommandUtils.selezionaProgramma(macchina, comando.getParametroAggiuntivo());
					lavanderia.setEsitoOperazione("Programma selezionato correttamente");
				} else  if (comando.getNome().equalsIgnoreCase("avvia")) {
					CommandUtils.avvia(macchina);
					lavanderia.setEsitoOperazione("Macchina avviata correttamente");
				} else  if (comando.getNome().equalsIgnoreCase("ferma")) {
					CommandUtils.ferma(macchina);
					lavanderia.setEsitoOperazione("Macchina fermata correttamente");
				} else if (comando.getNome().equalsIgnoreCase("detersivo")) {
					if (macchina instanceof Lavatrice) {
						CommandUtils.aggiungiDetersivo((Lavatrice)macchina, comando.getParametroAggiuntivo());
						lavanderia.setEsitoOperazione("Detersivo ricaricato");
					} else {
						throw new LavanderiaException("Macchina non è lavatrice");
					}
				}
				
			} catch (LavanderiaException e) {
				lavanderia.setEsitoOperazione(e.getMessage());
			}
			
		}
		
		scanner.close();
	}
	
}
