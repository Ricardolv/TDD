package com.richard.tdd.service;

import java.io.Serializable;

import com.richard.tdd.model.Funcionario;

public class CalculadoraDeSalario implements Serializable {

	private static final long serialVersionUID = 1L;

	public double calculaSalario(Funcionario funcionario) {
		
		if(funcionario.getSalario() > 3000) {
			return funcionario.getSalario() * 0.8;
		}

		if(funcionario.getSalario() <= 500) {
			return funcionario.getSalario() * 0.85;
		}
		
		return funcionario.getSalario() * 0.9;
	}

}
