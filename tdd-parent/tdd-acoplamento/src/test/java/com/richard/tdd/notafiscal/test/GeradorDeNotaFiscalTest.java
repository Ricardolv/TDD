package com.richard.tdd.notafiscal.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.richard.tdd.notafiscal.AcaoAposGerarNota;
import com.richard.tdd.notafiscal.GeradorDeNotaFiscal;
import com.richard.tdd.notafiscal.NotaFiscal;
import com.richard.tdd.notafiscal.Pedido;
import com.richard.tdd.notafiscal.Tabela;

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

	@Test
	public void deveConsultarATabelaParaCalcularValor() {
		// mockando uma tabela, que ainda nem existe
		Tabela tabela = Mockito.mock(Tabela.class);
		
		// definindo o futuro comportamento "paraValor",
		// que deve retornar 0.2 caso o valor seja 1000.0
		Mockito.when(tabela.paraValor(1000.0)).thenReturn(0.2);
		
		List<AcaoAposGerarNota> nenhumaAcao = Collections.emptyList();
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(nenhumaAcao, null, tabela);
		
		Pedido pedido = new Pedido("Mauricio", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);
		// garantindo que a tabela foi consultada
		Mockito.verify(tabela).paraValor(1000.0);
		
		assertEquals(1000 * 0.2, nf.getValor(), 0.00001);
	}

}