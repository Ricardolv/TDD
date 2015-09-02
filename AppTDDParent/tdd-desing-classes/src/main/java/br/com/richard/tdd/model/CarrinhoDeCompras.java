package br.com.richard.tdd.model	;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author richard
 */
public class CarrinhoDeCompras {

	private List<Item> itens = new ArrayList<>();
	
	public CarrinhoDeCompras() {
	}

	public CarrinhoDeCompras(List<Item> itens) {
		this.itens = itens;
	}

	public void adiciona(Item item) {
		this.itens.add(item);
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
}