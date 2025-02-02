## Descrição
Este código gera uma matriz com n sequências aleatórias de números entre 1 e 60 para apostas na Mega-Sena. O código sorteia 60 números aleatórios e os divide em 10 sequências de 6 números cada, garantindo que não existam sequências idênticas.

A cada 10 apostas, todos os 60 números possíveis (de 1 a 60) estarão presentes pelo menos uma vez.
Exemplo:
 - Se o usuário solicitar 180 apostas, receberá 180 sequências de 6 números cada, sem repetições de sequências idênticas. Além disso, a cada 10 sequências, todos os 60 números possíveis estarão presentes, organizados de forma diferente.

## COMPILANDO
Para compilar o código, utilize o comando abaixo:
```bash
javac -d bin/ src/**/*.java
```

## GERANDO O ARQUIVO .JAR
Para se ter o projeto em arquivo único, basta usar o comando abaixo:
```bash
jar cfm megasena.jar MANIFEST.MF -C bin .
```
Este comando pressupõe a existência do arquivo `MANIFEST.MF` presente na raiz do projeto.
O conteúdo do arquivo `MANIFEST.MF` deve ser o seguinte:

```text
Manifest-Version: 1.0
Main-Class: Main
```

## EXECUTANDO O PROGRAMA
Para executar o programa, digite no terminal o seguinte comando:
```bash
java -jar megasena.jar
```
Ou 
```bash
java -jar megasena.jar 120 1000
```
Neste último caso, serão geradas 1000 apostas aleatórias, com o número da sorte 120 (seed).

O comando acima pressupõe que o usuário está no diretório onde presente o arquivo `megasena.jar`.

## Saída
As apostas serão salvas no arquivo `apostas.txt`.

