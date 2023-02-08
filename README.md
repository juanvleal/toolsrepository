# toolsrepository

Esse projeto auxilia os devs a terem as informações das suas ferramentas favoritas em um único repositório, utilizando o JDK17.

## Começando

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 17: Necessário para executar o projeto Java](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
- [Maven 3.8.7: Necessário para realizar o build do projeto Java](https://maven.apache.org/download.cgi)

## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/juanvleal/toolsrepository
```
### Construção

Para construir e executar o projeto com o Maven, executar os comando abaixo:

```shell
mvn spring-boot:run
```

O comando irá baixar todas as dependências do projeto, criar um diretório *target* com os artefatos construídos, que incluem o arquivo jar do projeto e executar o projeto em localhost na porta 3000.

## Testes

Para rodar os testes, utilize o comando abaixo:

```
mvn test
```

........