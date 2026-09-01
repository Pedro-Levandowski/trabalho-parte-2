import java.util.Stack;

public class AvaliadorRPN {

    public static double avaliar(String expressaoRPN) {
        Stack<Double> pilha = new Stack<>();
        String[] tokens = expressaoRPN.trim().split("\\s+");

        for (String token : tokens) {
            if (ehOperador(token)) {
                double b = pilha.pop();
                double a = pilha.pop();
                pilha.push(aplicarOperador(a, b, token));
            } else {
                pilha.push(Double.parseDouble(token));
            }
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
