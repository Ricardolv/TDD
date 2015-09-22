package com.richard.tdd.model	;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 * @since 02/04/2015
 */
public class CarrinhoDeCompras {

	private List<Produto> produtos;

	public List<Produto> getProdutos() {
		if (produtos == null) {
			produtos = new ArrayList<>();
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void adiciona(Produto produto) {
		getProdutos().add(produto);
	}
}