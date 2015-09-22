package com.richard.tdd.copiadora.test;

import org.junit.Test;
import org.mockito.Mockito;

import com.richard.tdd.copiadora.Copiadora;
import com.richard.tdd.copiadora.Escritor;
import com.richard.tdd.copiadora.Leitor;

public class CopiadoraTest {

	@Test
	public void deveLerEEnviarOConteudoLido() {
		Escritor e = Mockito.mock(Escritor.class);
		Leitor l = Mockito.mock(Leitor.class);
		
		Mockito.when(l.temCaracteres()).thenReturn(true, false);
		Mockito.when(l.leCaracteres()).thenReturn("mauricio");
		
		Copiadora c = new Copiadora(l, e);
		c.copiar();
		
		Mockito.verify(e).escreve("mauricio");
	}
}
