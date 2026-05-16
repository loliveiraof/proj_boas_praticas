package BoasPraticas;

public class AnalisadorDeTextos {
    private static final String TERMO_FONTE = "FONTE";
    private static final String TERMO_ALERTA = "!!!";
    private static final String TERMO_URGENTE = "URGENTE";
    private static final int TAMANHO_MINIMO = 10;

    /**
     * Analisa o texto e calcula uma pontuação de risco para classificar a mensagem.
     * @param texto Conteúdo a ser avaliado.
     * @return Classificação gerada ("confiavel", "duvidosa" ou "falsa").
     */
    public static String avaliar(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "duvidosa";
        }

        int pontuacaoDeRisco = 0;

        if (!texto.contains(TERMO_FONTE)) pontuacaoDeRisco++;
        if (texto.contains(TERMO_ALERTA)) pontuacaoDeRisco++;
        if (texto.contains(TERMO_URGENTE)) pontuacaoDeRisco++;
        if (texto.length() < TAMANHO_MINIMO) pontuacaoDeRisco++;

        if (pontuacaoDeRisco == 0) return "confiavel";
        if (pontuacaoDeRisco == 1) return "duvidosa";
        
        return "falsa";
    }
}