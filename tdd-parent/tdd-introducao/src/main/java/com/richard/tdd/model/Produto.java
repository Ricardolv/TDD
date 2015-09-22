package com.richard.tdd.model;

/**
 * @author richard
 * @since 02/04/2015
 */
public class Produto {

	private String nome;
	private Double valor;

	public Produto(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
