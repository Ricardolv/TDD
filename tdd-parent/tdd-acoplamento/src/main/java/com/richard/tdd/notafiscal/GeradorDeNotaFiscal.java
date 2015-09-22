package com.richard.tdd.notafiscal;

import java.util.List;

public class GeradorDeNotaFiscal {

	private final List<AcaoAposGerarNota> acoes;
	private final Relogio relogio;

	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes, Relogio relogio) {
		this.acoes = acoes;
		this.relogio = relogio;
	}
	
	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes) {
		this(acoes, new RelogioDoSistema());
	}

	public NotaFiscal gera(Pedido pedido) {
		
		NotaFiscal nf = new NotaFiscal(
				pedido.getCliente(),
				pedido.getValorTotal() * 0.94,
				relogio.hoje());

		for (AcaoAposGerarNota acao : acoes) {
			acao.executa(nf);
		}

		return nf;
	}

}