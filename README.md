# trabalho-parte-2

Aplicação em Java que recebe uma expressão matemática em notação infixa, converte para Notação Polonesa Reversa (RPN) e calcula o resultado utilizando uma pilha.

## Como funciona

1. **Leitura da expressão** (`Main`): o usuário digita uma expressão matemática infixa (ex: `(3 + 4) * 2`).
2. **Conversão para RPN** (`ConversorRPN`): a expressão é convertida para RPN usando o algoritmo de Shunting-yard, respeitando precedência de operadores (`*` e `/` antes de `+` e `-`) e parênteses.
3. **Avaliação da RPN** (`AvaliadorRPN`): a expressão convertida é percorrida da esquerda para a direita usando uma pilha de `Double`:
   - se o token for um número, ele é empilhado;
   - se for um operador (`+`, `-`, `*`, `/`), os dois últimos valores são retirados da pilha, a operação é realizada com `double` e o resultado volta para a pilha.
   - ao final, o único valor restante na pilha é o resultado da expressão.
4. **Tratamento de erros**: divisão por zero (`ArithmeticException`) e expressões inválidas, como operandos insuficientes ou sobra de valores na pilha (`IllegalArgumentException`), são tratadas e exibem uma mensagem de erro em vez de quebrar o programa.

Ao final, o programa exibe a expressão original, a expressão convertida em RPN e o resultado calculado.

## Como executar

Pelo IntelliJ IDEA, basta rodar a classe `Main`.

Pela linha de comando, a partir da pasta do projeto:

```bash
javac -d out src/*.java
java -cp out Main
```

O programa primeiro executa 5 exemplos fixos de teste e depois pede para o usuário digitar sua própria expressão.

## Exemplos de teste

| Expressão original | RPN | Resultado |
|---|---|---|
| `3 + 4 * 2` | `3 4 2 * +` | `11.0` |
| `(3 + 4) * 2` | `3 4 + 2 *` | `14.0` |
| `10 / 2 - 3` | `10 2 / 3 -` | `2.0` |
| `2.5 + 3.7 * 2` | `2.5 3.7 2 * +` | `9.9` |
| `(8.5 - 3.5) / (1 + 4)` | `8.5 3.5 - 1 4 + /` | `1.0` |

Os exemplos incluem números inteiros, números decimais, uso de parênteses e diferentes precedências de operadores.
