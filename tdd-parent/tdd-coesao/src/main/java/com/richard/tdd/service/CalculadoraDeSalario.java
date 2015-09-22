package com.richard.tdd.service;

import java.io.Serializable;

import com.richard.tdd.model.Funcionario;

public class CalculadoraDeSalario implements Serializable {

	private static final long serialVersionUID = 1L;

	public double calculaSalario(Funcionario funcionario) {
		return funcionario.getCargo().getRegra().calcula(funcionario);
	}

}