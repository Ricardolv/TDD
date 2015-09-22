package com.richard.tdd.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.richard.tdd.model.Cargo;
import com.richard.tdd.model.Funcionario;
import com.richard.tdd.service.CalculadoraDeSalario;

public class CalculadoraDeSalarioTest {
	
	
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite() {

		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Mauricio", 1500.0, Cargo.DESENVOLVEDOR);
		double salario = calculadora.calculaSalario(desenvolvedor);

		assertEquals(1500.0 * 0.9, salario, 0.00001);
	}

	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite() {
		

		Funcionario desenvolvedor = new Funcionario("Mauricio", 4000.0, Cargo.DESENVOLVEDOR);
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		double salario = calculadora.calculaSalario(desenvolvedor);

		assertEquals(4000.0 * 0.8, salario, 0.00001);
	}

	@Test
	public void deveCalcularSalarioParaDBAsComSalarioAbaixoDoLimite() {
		
		Funcionario desenvolvedor = new Funcionario("Mauricio", 500.0, Cargo.DBA);
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(500.0 * 0.85, salario, 0.00001);
	}
}