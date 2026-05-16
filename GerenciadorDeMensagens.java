package BoasPraticas;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeMensagens {
    private List<Mensagem> mensagens = new ArrayList<>();

    /**
     * Valida e adiciona uma nova mensagem ao banco de dados em memória.
     * @param conteudo O texto principal da mensagem.
     * @param classificacao A classificação manual ou automática.
     * @return true se a operação for bem-sucedida, false se os dados forem inválidos.
     */
    public boolean adicionarMensagem(String conteudo, String classificacao) {
        if (conteudo == null || conteudo.trim().isEmpty()) {
            return false;
        }
        Mensagem novaMensagem = new Mensagem(conteudo, classificacao);
        mensagens.add(novaMensagem);
        return true;
    }

    public List<Mensagem> listarMensagens() {
        return mensagens;
    }
}