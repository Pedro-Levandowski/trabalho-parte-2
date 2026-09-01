import java.util.Stack;

public class AvaliadorRPN {

    public static double avaliar(String expressaoRPN) {
        Stack<Double> pilha = new Stack<>();
        String[] tokens = expressaoRPN.trim().split("\\s+");

        for (String token : tokens) {
            if (ehOperador(token)) {
                if (pilha.size() < 2) {
                    throw new IllegalArgumentException(
                            "Expressao invalida: operandos insuficientes para o operador '" + token + "'.");
                }

                double b = pilha.pop();
                double a = pilha.pop();
                pilha.push(aplicarOperador(a, b, token));
            } else {
                pilha.push(Double.parseDouble(token));
            }
        }

        if (pilha.size() != 1) {
            throw new IllegalArgumentException("Expressao invalida: valores restantes na pilha ao final da avaliacao.");
        }

        return pilha.pop();
    }

    private static double aplicarOperador(double a, double b, String operador) {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Divisao por zero.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operador desconhecido: " + operador);
        }
    }

    private static boolean ehOperador(String token) {
        return token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/");
    }
}
