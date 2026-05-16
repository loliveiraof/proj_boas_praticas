package BoasPraticas;

public class Mensagem {
	private String conteudo;
	private String classificacao;
	
	public Mensagem(String conteudo, String classificacao) {
		this.conteudo = conteudo;
		if (classificacao == null || classificacao.trim().isEmpty()) {
			this.classificacao = "duvidosa";
		} else {
			this.classificacao = classificacao;
		}
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public String getClassificacao() {
		return classificacao;
	}
}