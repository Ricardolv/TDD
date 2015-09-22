package com.richard.tdd.notafiscal.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.richard.tdd.notafiscal.AcaoAposGerarNota;
import com.richard.tdd.notafiscal.GeradorDeNotaFiscal;
import com.richard.tdd.notafiscal.NotaFiscal;
import com.richard.tdd.notafiscal.Pedido;

public class GeradorDeNotaFiscalTest {

//	@Test
//	public void deveGerarNFComValorDeImpostoDescontado() {
//		//Mock Objects
//		NFDao dao = Mockito.mock(NFDao.class);
//		SAP sap = Mockito.mock(SAP.class);
//
//		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(dao, sap);
//		Pedido pedido = new Pedido("Mauricio", 1000, 1);
//		NotaFiscal nf = gerador.gera(pedido);
//
//		assertEquals(1000 * 0.94, nf.getValor(), 0.0001);
//	}
//
//	@Test
//	public void devePersistirNFGerada() {
//		//Mock Objects
//		NFDao dao = Mockito.mock(NFDao.class);
//		SAP sap = Mockito.mock(SAP.class);
//
//		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(dao, sap);
//
//		Pedido pedido = new Pedido("Mauricio", 1000, 1);
//		NotaFiscal nf = gerador.gera(pedido);
//
//		// verificando que o método foi invocado
//		Mockito.verify(dao).persiste(nf);
//	}
//
//	@Test
//	public void deveEnviarNFGeradaParaSAP() {
//		//Mock Objects
//		NFDao dao = Mockito.mock(NFDao.class);
//		SAP sap = Mockito.mock(SAP.class);
//
//		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(dao, sap);
//
//		Pedido pedido = new Pedido("Mauricio", 1000, 1);
//		NotaFiscal nf = gerador.gera(pedido);
//
//		// verificando que o método foi invocado
//		Mockito.verify(sap).envia(nf);
//	}

	@Test
	public void deveInvocarAcoesPosteriores() {
		AcaoAposGerarNota acao1 = Mockito.mock(AcaoAposGerarNota.class);
		AcaoAposGerarNota acao2 = Mockito.mock(AcaoAposGerarNota.class);
		List<AcaoAposGerarNota> acoes = Arrays.asList(acao1, acao2);
		
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes);
		Pedido pedido = new Pedido("Mauricio", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);

		Mockito.verify(acao1).executa(nf);
		Mockito.verify(acao2).executa(nf);
	}

}