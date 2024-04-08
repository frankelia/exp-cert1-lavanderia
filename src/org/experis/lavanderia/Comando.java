package org.experis.lavanderia;

public class Comando {
	private String nome;
	
	private int numeroMacchina;
	
	private Integer parametroAggiuntivo;

	public Comando(String nome, int numeroMacchina, Integer parametroAggiuntivo) {
		this.nome = nome;
		this.numeroMacchina = numeroMacchina;
		this.parametroAggiuntivo = parametroAggiuntivo;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMacchina() {
		return numeroMacchina;
	}

	public Integer getParametroAggiuntivo() {
		return parametroAggiuntivo;
	}

	@Override
	public String toString() {
		return "Comando [nome=" + nome + ", numeroMacchina=" + numeroMacchina + ", parametroAggiuntivo="
				+ parametroAggiuntivo + "]";
	}
	
	
}
