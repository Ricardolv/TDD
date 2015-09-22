package com.richard.tdd.copiadora;

public class Copiadora {

	public Copiadora(Leitor l, Escritor e) {

	}

	public void copiar() {
		LeitorDeXML leitor = new LeitorDeXML();
		EscritorPelaSerial escritor = new EscritorPelaSerial();
		while (leitor.temCaracteres()) {
			escritor.escreve(leitor.leCaracteres());
		}
	}

}
