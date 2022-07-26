package br.com.lucio.escola.dominio;

import java.util.ArrayList;
import java.util.List;

public class PublicadorEventos {

	private List<Ouvinte> ouvites  = new ArrayList<>();
	
	public void adicionarOuvinte(Ouvinte ouvinte) {
		this.ouvites.add(ouvinte);
	}
	
	public void publicar(Evento evento) {
		ouvites.forEach(ouvinte -> ouvinte.processa(evento));
	}
	
}
