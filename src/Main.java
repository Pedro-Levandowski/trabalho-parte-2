import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma expressão matemática: ");
        String expressao = scanner.nextLine();

        String expressaoRPN = ConversorRPN.converter(expressao);
        double resultado = AvaliadorRPN.avaliar(expressaoRPN);

        System.out.println();
        System.out.println("Expressão original: " + expressao);
        System.out.println("Expressão RPN: " + expressaoRPN);
        System.out.println("Resultado: " + resultado);

        scanner.close();
    }
}
