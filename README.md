# OBIExplorerMobile
Bem-vindo ao repositório do OBIExplorerMobile, uma versão Mobile de uma aplicação web desenvolvida na UDESC para facilitar os estudos de programação competitiva possibilitando consultar um repositório completo de questões de maratonas de programação e olimpíadas de programação.

Para utilizar este projeto, é necessário possuir uma instalação do JDK configurada em sua máquina (preferência por versões mais atualizadas como a 21).

Para o backend da aplicação, deve ser executado o projeto Java encontrado na pasta <b>obiexploermobile</b> em sua IDE de preferência (**Sugestão:** utilizar IDEA IntelliJ), mas a porta 8080 deve estar disponível para uso pelo servidor. 

Para o frontend da aplicação, é preciso ter o Android Studio configurado e instalado corretamente com uma máquina virtual para emulação da aplicação. A versão mínima do SDK é a 24, enquanto a versão alvo é a 34. Com isso, é possível executar a classe MainActivity.java para inicializar o projeto.
A pasta do projeto é a <b>OBIExplorerMobile</b>.

Importante! Inicializar primeiro o backend e depois o frontend para que o carregamento dos dados ocorra corretamente.

A aplicação permite que você filtre questões da OBI por diversos aspectos como título, enunciado, ano da prova, fase etc.

Os campos título e enunciado são campos de texto livre, enquanto o restante disponibiliza uma lista de valores para seleção. Apenas um valor pode ser selecionado por campo e o valor "Selecione" atua como um "vazio", ou seja, não é considerado para o filtro. Os filtros podem ser redefinidos por meio do botão vermelho "Limpar Filtros".

Ao clicar no botão verde "Buscar questões" é carregada uma lista com as questões conforme o usuário inseriu as informações nos filtros. Caso não tenha inserido informações, retorna todas as questões. 

Cada questão inicialmente apresenta nome, ano da prova e fase em que foi aplicada, se esta for clicada as informações serão expandidas apresentando modalidade da prova da questão e a dificuldade da questão. Por fim é apresentado um "Link" que redireciona para a questão completa, isto é, abre o navegador padrão com a URL já definida. 

Se a quantidade de questões for suficiente para ocupar mais espaço do que o disponível em tela, a aplicação habilita uma barra de rolagem para visualização completa do conteúdo.
Apenas uma questão pode ser expandida por vez.

Importante! É necessário que o dispositivo permita que a aplicação conceda o acesso à internet para o carregamento correto das informações.

Desenvolvido por Leonardo Rócio, Lucas Augusto de Oliveira e Vitor Valentin de Oliveira.
