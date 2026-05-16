* # Sistema de Avaliação de Textos

# 

* # Descrição do Projeto

# Este é um sistema de linha de comando desenvolvido/refatorado em Java para gerenciar e classificar a credibilidade de textos. O projeto é o resultado de um exercício de refatoração.

# O sistema permite que o usuário adicione mensagens informando a classificação manualmente ou utilize um motor de análise automática baseado em regras de pontuação de risco.

# 

* # Estrutura do Projeto (Refatorado)

# O código original foi dividido em quatro classes principais dentro do pacote `BoasPraticas`, garantindo a separação de responsabilidades:

# \*   `Mensagem.java`: Classe de modelo que encapsula os dados (conteúdo e classificação).

# \*   `AnalisadorDeTextos.java`: Classe de serviço que contém exclusivamente a lógica e as regras matemáticas de classificação de risco.

# \*   `GerenciadorDeMensagens.java`: Classe de repositório responsável por armazenar as mensagens em memória.

# \*   `Sistema.java`: Classe principal que gerencia o fluxo de execução e a interface interativa com o usuário.

# 

* # Regras de Classificação Automática

# Quando o usuário opta por adicionar uma mensagem automaticamente, o sistema calcula uma "pontuação de risco".

# 

# As seguintes condições adicionam \*\*+1 ponto de risco\*\* cada:

# 1\. O texto \*\*não\*\* contém a palavra "FONTE".

# 2\. O texto contém sinais de alerta "!!!".

# 3\. O texto contém a palavra "URGENTE".

# 4\. O texto possui menos de 10 caracteres.

# 

# \*\*Resultados da Classificação:\*\*

# \*   \*\*0 pontos:\*\* `confiavel`

# \*   \*\*1 ponto:\*\* `duvidosa`

# \*   \*\*2 ou mais pontos:\*\* `falsa`

# \*(Nota: Entradas em branco ou nulas são tratadas defensivamente e classificadas como "duvidosa" por padrão).\*

# 

* # Pré-requisitos

# \*   Java Development Kit (JDK) 8 ou superior instalado.

