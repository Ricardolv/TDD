package br.com.richard.tdd.service;

import br.com.richard.tdd.model.CarrinhoDeCompras;
import br.com.richard.tdd.model.Produto;



/**
 * @author richard
 * @since 02/04/2015
 */
public class MaiorEMenor {

	private Produto menor;
	private Produto maior;

	public void encontrar(CarrinhoDeCompras carrinho) {

		for (Produto produto : carrinho.getProdutos()) {

			if (menor == null || produto.getValor() < menor.getValor()) {
				menor = produto;
			}
			if (maior == null || produto.getValor() > maior.getValor()) {
				maior = produto;
			}
		}

	}

	public Produto getMenor() {
		return menor;
	}


	public void setMenor(Produto menor) {
		this.menor = menor;
	}


	public Produto getMaior() {
		return maior;
	}


	public void setMaior(Produto maior) {
		this.maior = maior;
	}


}
