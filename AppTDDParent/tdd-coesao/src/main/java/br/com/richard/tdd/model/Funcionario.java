package br.com.richard.tdd.model;

import java.io.Serializable;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private double salario;
	private Cargo cargo;
	
	public Funcionario(String nome, double salario, Cargo cargo) {
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
