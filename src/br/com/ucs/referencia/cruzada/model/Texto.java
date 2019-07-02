package br.com.ucs.referencia.cruzada.model;

public class Texto {
	public String titulo;
	public String conteudo;
	public Texto nextTexto;

	public Texto(String titulo, String conteudo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public Texto() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
