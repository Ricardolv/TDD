package com.richard.tdd.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.richard.tdd.model.CarrinhoDeCompras;
import br.com.richard.tdd.model.Item;

import com.richard.tdd.service.MaiorPreco;

public class MaiorPrecoTest {

	@Test
	public void deveRetornarZeroSeCarrinhoVazio(){

		MaiorPreco algoritmo = new MaiorPreco();
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		double valor = algoritmo.encontra(carrinho);

		assertEquals(0.0, valor, 0.0001);
	}

	@Test
	public void deveRetornarValorDoItemSeCarrinhoCom1Elemento() {

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));

		MaiorPreco algoritmo = new MaiorPreco();
		double valor = algoritmo.encontra(carrinho);

		assertEquals(900.0, valor, 0.0001);
	}

}