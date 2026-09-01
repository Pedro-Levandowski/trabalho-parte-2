import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Exemplos de teste =====");
        executarExemplos();

        System.out.println();
        System.out.println("===== Digite sua expressão =====");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma expressão matemática: ");
        String expressao = scanner.nextLine();

        processarExpressao(expressao);

        scanner.close();
    }

    private static void executarExemplos() {
        String[] exemplos = {
                "3 + 4 * 2",
                "(3 + 4) * 2",
                "10 / 2 - 3",
                "2.5 + 3.7 * 2",
                "(8.5 - 3.5) / (1 + 4)"
        };

        for (String exemplo : exemplos) {
            processarExpressao(exemplo);
        }
    }

    private static void processarExpressao(String expressao) {
        String expressaoRPN = ConversorRPN.converter(expressao);

        System.out.println();
        System.out.println("Expressão original: " + expressao);
        System.out.println("Expressão RPN: " + expressaoRPN);

        try {
            double resultado = AvaliadorRPN.avaliar(expressaoRPN);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Erro ao avaliar a expressão: " + e.getMessage());
        }
    }
}
