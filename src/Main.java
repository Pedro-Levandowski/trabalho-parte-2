import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma expressão matemática: ");
        String expressao = scanner.nextLine();

        String expressaoRPN = ConversorRPN.converter(expressao);

        System.out.println();
        System.out.println("Expressão original: " + expressao);
        System.out.println("Expressão RPN: " + expressaoRPN);

        scanner.close();
    }
}
