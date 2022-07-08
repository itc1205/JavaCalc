import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String user_input = scanner.nextLine();

        System.out.println(calculate(user_input));
    }

    public static String calculate(String input) throws Exception {
        boolean RomeMode = false;
        String[] strArr = input.split(" ");
        if (strArr.length != 3) {
            throw new Exception();
        }

        int a;
        int b;

        try {
            a = Integer.parseInt(strArr[0]);
            b = Integer.parseInt(strArr[2]);
        } catch (NumberFormatException e) {
            a = MathOperations.toDec(strArr[0]);
            b = MathOperations.toDec(strArr[2]);
            RomeMode = true;
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception();
        }

        String operation = strArr[1];

        if (!RomeMode) {

            return switch (operation) {
                case "*" -> String.valueOf(a * b);
                case "/" -> String.valueOf(a / b);
                case "+" -> String.valueOf(a + b);
                case "-" -> String.valueOf(a - b);
                default -> throw new Exception();
            };
        } else {
            return switch (operation) {
                case "*" -> MathOperations.toRomanian(a * b);
                case "/" -> MathOperations.toRomanian(a / b);
                case "+" -> MathOperations.toRomanian(a + b);
                case "-" -> MathOperations.toRomanian(a - b);
                default -> throw new Exception();
            };
        }
    }
}