# Projeto PLP - Exceptions na Linguagem Imperativa

## Equipe

- Rafael Borba <rbcs@cin.ufpe.br>
- Fernando Oliveira <bfao@cin.ufpe.br>

## Resumo

Esse projeto tem como objetivo incluir o tratamento de exceções na Linguagem Imperativa 1. Serão tratadas exceções em 3 casos:

1. Exceções lançadas automaticamente pela linguagem
    - Nessa versão, a única possibilidade da linguagem lançar um exceção automaticamente será em erros de divisão por zero.
2. Exceções lançadas pelo programador que está utilizando a linguagem
    - Para isso o programador usará o comando `throw` passado uma mensagem de erro:
        - Ex.: `throw("throw str")`
3. Exceções lançadas pelo Java diretamente
    - Ex.: `java.lang.OutOfMemoryError`

Os erros passados para o comando `throw` podem ser de 3 tipos diferentes: string, integer ou boolean, que são os tipos atualmente suportados pela linguagem imperativa 1.

## Estrutura de Arquivos / Diretórios

|Arquivo / Diretório           | Descrição                                          |
|------------------------------|----------------------------------------------------|
| `/applet.jar`                | O applet do professor pra testar as linguagens     |
| `/javacc.jar`                | A versão do javacc que tem na página da disciplina |
| `/workspace`                 | Projeto Java (Usamos o Eclipse)                    |
| `/workspace/programa.txt`    | Um programa escrito em Li1 para testar             |

## Configurações para execução:

1. Importar o projeto no Eclipse;
2. Clique com o botão direto no projeto;
3. Selecione `Run as -> Run Configurations`;
4. Selecione `Java Application` na lista do lado esquerdo;
5. Selecione a aba `Arguments` no lado direito;
6. Inclua o caminho para o arquivo `programa.txt` no input `Program Arguments`;
    - > Padrão: C:\paradigmas\plp-rbcs-bfao\workspace\programa.txt
7. Clique em `Apply`;
8. Agora clique em `Run as -> Java Application`
