# Sistema de Gestão – Crianças do Amanhã

Sistema desktop e offline, desenvolvido de forma voluntária para o projeto social
**Crianças do Amanhã** (Rio de Janeiro). O objetivo é substituir o controle feito
em caderno por cadastros organizados, relatórios de atendimento e controle financeiro.

## Status

Em desenvolvimento.
- Modelagem e banco de dados: concluídos e validados.
- Aplicação em Java: próxima etapa.

## Funcionalidades previstas

- Cadastro de alunos e responsáveis, com matrícula única, vínculo de irmãos e até dois responsáveis por aluno
- Relatórios de atendimento
- Contas a pagar do mês, com situação (pendente ou paga) e balanço mensal
- Exportação de dados em CSV

## Decisões técnicas

- **Offline, em um único computador:** a usuária é uma só, então não há servidor nem internet.
- **SQLite:** o banco é um único arquivo, e o backup é uma cópia dele.
- **Java com POO** para a aplicação desktop.
- **Responsáveis em tabela própria:** um responsável com vários filhos é cadastrado uma só vez.
- **Endereço guardado no responsável**, sem duplicação nos alunos.
- **Datas gravadas como AAAA-MM-DD** e exibidas como dd-mm-aaaa nas telas.
- **Trava no banco** para a situação da conta aceitar apenas "pendente" e "paga".
- **Chaves estrangeiras** impedem, por exemplo, um atendimento ligado a um aluno inexistente.

## Estrutura

```
criar_tabelas.sql   # cria todas as tabelas do banco
```

## Como criar o banco

1. Abra o [DB Browser for SQLite](https://sqlitebrowser.org) e crie um banco novo.
2. Na aba *Execute SQL*, execute o conteúdo de `criar_tabelas.sql`.
3. Grave as alterações.

## Privacidade

Este repositório contém apenas o esquema do banco, sem nenhum dado.
Arquivos `.db` são ignorados pelo Git, e dados de crianças e responsáveis
nunca devem ser versionados.

## Autor

Christopher da Silva Santos – estudante de Sistemas de Informação.
