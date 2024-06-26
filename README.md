wwwwwww# Projeto - Prontuário Médico

## Introdução

Este projeto é um programa de prontuário médico desenvolvido em Java, projetado para gerenciar e organizar informações de pacientes e médicos de maneira eficiente e segura. O sistema possui um banco de dados integrado que armazena todas as informações pertinentes, facilitando o acesso e a atualização dos dados.

O sistema começa com um login inicial, onde o usuário deve inserir seu CPF. O sistema verifica o CPF no banco de dados para autenticar o usuário e mostra uma mensagem indicando se o acesso foi liberado ou negado. Após o login bem-sucedido, o usuário pode acessar informações detalhadas sobre os pacientes, criar novos prontuários médicos, verificar prontuários anteriores e utilizar um botão para voltar à tela de login inicial.

Essas funcionalidades permitem um gerenciamento eficaz dos dados médicos, proporcionando aos profissionais de saúde uma ferramenta valiosa para acompanhar e tratar seus pacientes. O programa garante que as informações médicas sejam mantidas organizadas e facilmente acessíveis, enquanto protege a privacidade e segurança dos dados dos pacientes.

## Tutorial de uso

### 1. Ter o Java 22 instalado

#### Passos para instalação:

1.1. Baixar o JDK 22:

- [Oracle JDK 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html).

1.2. Instalar o JDK:

- Após o download, siga as instruções do instalador para instalar o JDK no seu sistema operacional (Windows, macOS ou Linux).

1.3. Verificar a instalação:

- Abra o terminal ou prompt de comando e execute
  
  <pre><code>
  java -version
  </code></pre>
  
- Você deve ver uma mensagem indicando que o Java 22 está instalado.

### 2. Ter o MySQL Workbench instalado

#### Passos para instalação:

2.1. Baixar o MySQL Workbench:

- Vá até o site oficial do MySQL para baixar a versão mais recente do [MySQL Workbench](https://dev.mysql.com/downloads/installer/).

2.2. Instalar o MySQL Workbench:

- Siga as instruções do instalador para instalar o MySQL Workbench no seu sistema operacional.

### 3. Baixar o arquivo .sql

#### Passos para baixar:

3.1. Vá até o repositório do projeto no GitHub

3.2. Navegue até a seção ou pasta onde o arquivo .sql está localizado.

3.3. Clique no arquivo .sql e, em seguida, clique no botão "Download" ou "Raw" para salvar o arquivo no seu computador.

### 4. Efetuar a criação do banco de dados a partir do arquivo .sql

#### Passos para criar o banco de dados:

4.1. Abrir o MySQL Workbench:

- Inicie o MySQL Workbench.
- Conecte-se ao seu servidor MySQL local ou remoto.

4.2. Criar um novo banco de dados:

- No painel de navegação do MySQL Workbench, clique com o botão direito do mouse em "Schemas" e selecione "Create Schema...".
- Dê um nome ao novo banco de dados e clique em "Apply".

4.3. Importar o arquivo .sql:

- No menu principal, vá para "File > Open SQL Script...".
- Selecione o arquivo .sql que você baixou do GitHub.
- O conteúdo do arquivo será carregado em uma nova aba do editor de SQL.
- Clique no botão "Execute" (ícone de raio) para executar o script e criar as tabelas e dados especificados no arquivo .sql.

### 5. Baixar e instalar as fontes da pasta "resource"

#### Passos para baixar e instalar fontes:

5.1. Obter as fontes do GitHub:

- Vá até o repositório do projeto no GitHub.
- Navegue até a pasta "resource" onde as fontes estão localizadas.
- Baixe as fontes individualmente ou faça o download da pasta inteira como um arquivo ZIP clicando no botão "Code" e depois em "Download ZIP".

5.2. Instalar as fontes:

- No Windows:
  
Extraia o conteúdo do arquivo ZIP (se aplicável). Selecione todas as fontes (.ttf ou .otf), clique com o botão direito e selecione "Instalar".

- No macOS:

Extraia o conteúdo do arquivo ZIP (se aplicável). Abra o aplicativo "Font Book". Arraste e solte as fontes para o "Font Book" para instalá-las.

- No Linux:

Extraia o conteúdo do arquivo ZIP (se aplicável). Copie as fontes para o diretório ~/.fonts (você pode precisar criar esta pasta). Execute o comando fc-cache -fv no terminal para atualizar o cache de fontes.

### 6. Executar o arquivo Java

#### Passos para execução:

6.1. Baixar o código-fonte do projeto:

- Vá até o repositório do projeto no GitHub.
- Baixe o projeto como um arquivo ZIP clicando no botão "Code" e depois em "Download ZIP" ou clone o repositório usando Git:

  <pre><code>
  git clone https://github.com/usuario/projeto.git
  </code></pre>

6.2. Executar o projeto:

- Clique duas vezes no arquivo .jar.

## Conclusão

O projeto de prontuário médico em Java é uma solução avançada para gerenciar informações de pacientes e médicos de forma eficiente e segura. Integrando um banco de dados robusto e funcionalidades como autenticação via CPF, acesso detalhado aos prontuários e criação de novos registros, o sistema oferece aos profissionais de saúde uma plataforma completa para acompanhar tratamentos. A capacidade de verificar prontuários anteriores e a ênfase na segurança dos dados garantem uma gestão organizada e acessível das informações médicas, contribuindo para um atendimento de excelência e personalizado aos pacientes.

## Banco de Dados

### Dados para utilização no acesso ao sistema

1. Pacientes (CPF):

- 12345678901: Lucas Oliveira.
- 23456789012: Mariana Costa.
- 34567890123: Carlos Santos.
- 45678901234: Fernanda Lima.
- 56789012345: Rafael Almeida.
- 67890123456: Amanda Ferreira.
- 78901234567: Gustavo Martins.
- 89012345678: Juliana Rodrigues.
- 90123456789: Pedro Carvalho.
- 01234567890: Bianca Souza.

2. Funcionários (CPF e senha):

- 11122233344 e abc123: José Silva.
- 22233344455 e def456: Maria Santos.
- 33344455566 e ghi789: Carlos Oliveira.
- 44455566677 e jkl012: Ana Costa.
- 55566677788 e mno345: Fernanda Pereira.
- 66677788899 e pqr678: Paulo Lima.
- 77788899900 e stu901: Mariana Souza.
- 88899900011 e vwx234: Rodrigo Alves.
- 99900011122 e yzab56: Aline Rodrigues.
- 00011122233 e cdef78: Gustavo Santos.
