package br.com.richard.tdd.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.richard.tdd.model.CarrinhoDeCompras;
import br.com.richard.tdd.model.Produto;
import br.com.richard.tdd.service.MaiorEMenor;

/**
 * @author richard
 * @since 02/04/2015
 */
public class TestaMaiorEMenor {

	@Test
	public void ordemDecrescente() {

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(new Produto("Geladeira", 450.0));
		carrinho.adiciona(new Produto("Liquidificador", 250.0));
		carrinho.adiciona(new Produto("Jogo de pratos", 70.0));

		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontrar(carrinho);

		Assert.assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());

	}

	@Test
	public void apenasUmProduto() {
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(new Produto("Geladeira", 450.0));

		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontrar(carrinho);
		
		Assert.assertEquals("Geladeira", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());
	}
}
