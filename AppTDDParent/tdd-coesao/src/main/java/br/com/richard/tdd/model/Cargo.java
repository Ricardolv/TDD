package br.com.richard.tdd.model;

import com.richard.tdd.service.DezOuVintePorCento;
import com.richard.tdd.service.QuinzeOuVinteCincoPorCento;
import com.richard.tdd.service.RegraDeCalculo;

public enum Cargo {

	DESENVOLVEDOR(new DezOuVintePorCento()),
	DBA(new QuinzeOuVinteCincoPorCento()),
	TESTADOR(new QuinzeOuVinteCincoPorCento());

	private final RegraDeCalculo regra;

	Cargo(RegraDeCalculo regra) {
		this.regra = regra;
	}
	public RegraDeCalculo getRegra() {
		return regra;
	}

}
