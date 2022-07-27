package br.com.lucio.escola.academico.dominio;

public abstract class Ouvinte {

	public void processa(Evento evento) {
		if(this.deveProcessar(evento)) {
			this.reageAo(evento);
		}
	}

	protected abstract boolean deveProcessar(Evento evento);
	protected abstract void reageAo(Evento evento);

}