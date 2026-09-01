import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConversorRPN {

    public static String converter(String expressao) {
        List<String> saida = new ArrayList<>();
        Stack<Character> operadores = new Stack<>();

        StringBuilder numero = new StringBuilder();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (Character.isDigit(caractere) || caractere == '.') {
                numero.append(caractere);
            } else {
                if (!numero.isEmpty()) {
                    saida.add(numero.toString());
                    numero.setLength(0);
                }

                if (Character.isWhitespace(caractere)) {
                    continue;
                }

                if (caractere == '(') {
                    operadores.push(caractere);
                } else if (caractere == ')') {
                    while (!operadores.isEmpty()
                            && operadores.peek() != '(') {
                        saida.add(String.valueOf(operadores.pop()));
                    }

                    if (!operadores.isEmpty()
                            && operadores.peek() == '(') {
                        operadores.pop();
                    }
                } else if (ehOperador(caractere)) {
                    while (!operadores.isEmpty()
                            && operadores.peek() != '('
                            && precedencia(operadores.peek()) >= precedencia(caractere)) {

                        saida.add(String.valueOf(operadores.pop()));
                    }

                    operadores.push(caractere);
                }
            }
        }

        if (!numero.isEmpty()) {
            saida.add(numero.toString());
        }

        while (!operadores.isEmpty()) {
            saida.add(String.valueOf(operadores.pop()));
        }

        return String.join(" ", saida);

    }

    private static int precedencia(char operador) {
        if(operador == '+' || operador == '-') {
            return 1;
        }

        if(operador == '*' || operador == '/') {
            return 2;
        }

        return 0;
    }

    private static boolean ehOperador(char caractere) {
        return caractere == '+'
                || caractere == '-'
                || caractere == '*'
                || caractere == '/';
    }
}
