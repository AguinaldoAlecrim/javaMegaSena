## Descrição
Este código gera uma matriz com n sequências aleatórias de números entre 1 e 60 para apostas na Mega-Sena. O código sorteia 60 números aleatórios e os divide em 10 sequências de 6 números cada, garantindo que não existam sequências idênticas.

A cada 10 apostas, todos os 60 números possíveis (de 1 a 60) estarão presentes pelo menos uma vez.
Exemplo:
 - Se o usuário solicitar 180 apostas, receberá 180 sequências de 6 números cada, sem repetições de sequências idênticas. Além disso, a cada 10 sequências, todos os 60 números possíveis estarão presentes, organizados de forma diferente.

O algoritmo é de alta complexidade e seu tempo de execução aumenta conforme o número de apostas escolhidas pelo usuário. Isso ocorre porque, à medida que o número de apostas aumenta, torna-se mais difícil gerar uma nova sequência aleatória de 60 números sem repetir uma das 10 sequências já incluídas. Dessa forma, é inviável computacionalmente a geração de 1.000.000 (um milhão) de apostas. O programa apresenta bom desempenho apenas para valores baixos (até 10.000 apostas).
## COMPILANDO
Para compilar o código, utilize o comando abaixo:
```bash
javac -d bin/ src/**/*.java
```

## GERANDO O ARQUIVO .JAR
Para gerar um arquivo executável do projeto, utilize o seguinte comando:
```bash
jar cfm megasena.jar MANIFEST.MF -C bin .
```
Este comando pressupõe a existência do arquivo `MANIFEST.MF` na raiz do projeto. O conteúdo desse arquivo deve ser:

```text
Manifest-Version: 1.0
Main-Class: Main
```

## EXECUTANDO O PROGRAMA
Para executar o programa, utilize o seguinte comando no terminal:
```bash
java -jar megasena.jar
```
Ou, para especificar um número da sorte (seed) e a quantidade de apostas, utilize: 
```bash
java -jar megasena.jar 120 1000
```
No exemplo acima, serão geradas 1000 apostas aleatórias, utilizando 120 como seed.

O comando pressupõe que o usuário esteja no diretório onde o arquivo `megasena.jar` está localizado.

## Versões
Javac:
```
javac 21.0.5
```
Java:
```
java 21.0.5 2024-10-15 LTS
```
Jar:
```
jar 21.0.5
```

## Saída
As apostas serão salvas no arquivo `apostas.txt`.

