import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConversorRPN {

    public static String converter(String expressao) {
        List<String> saida = new ArrayList<>();
        Stack<Character> operadores = new Stack<>();

        return "";
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

    private static boolean ehOperdor(char caractere) {
        return caractere == '+'
                || caractere == '-'
                || caractere == '*'
                || caractere == '/';
    }
}
