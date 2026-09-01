import java.util.Stack;

public class AvaliadorRPN {

    public static double avaliar(String expressaoRPN) {
        Stack<Double> pilha = new Stack<>();
        String[] tokens = expressaoRPN.trim().split("\\s+");

        for (String token : tokens) {
            if (ehOperador(token)) {
                double b = pilha.pop();
                double a = pilha.pop();
                pilha.push(operar(a, b, token));
            } else {
                pilha.push(Double.parseDouble(token));
            }
        }

        return pilha.pop();
    }

    private static double operar(double a, double b, String operador) {
        if (operador.equals("+")) {
            return a + b;
        }
        if (operador.equals("-")) {
            return a - b;
        }
        if (operador.equals("*")) {
            return a * b;
        }
        return a / b;
    }

    private static boolean ehOperador(String token) {
        return token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/");
    }
}
