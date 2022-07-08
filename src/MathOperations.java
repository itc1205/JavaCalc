import java.util.List;

public class MathOperations {


    public static int toDec(String romanNumeral) throws Exception{
        /* Спасибо за алгоритм
        * https://javascopes.com/java-convert-roman-arabic-464cb361/
        */

        int result = 0;

        List romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = (RomanNumeral) romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new Exception();
        }

        return result;
    }

    public static String toRomanian(int a) throws Exception {

        StringBuilder result = new StringBuilder();

        if (a < 1) {
            throw new Exception();
        }
        int hundreds = a / 100;
        int decimals = a / 10 - hundreds * 10;
        int ones = a - hundreds * 100 - decimals * 10;

        //Обрабатываем сотню
        if (hundreds != 0) {
            result.append("C");
        }
        //Обрабатываем десятки
        if (decimals == 9 ) {
            result.append("XC");
        } else if (decimals < 9 && decimals >=5) {
            result.append("L");
            result.append("X".repeat(decimals - 5));
        } else if (decimals == 4) {
            result.append("XL");
        } else if (decimals < 4) {
            result.append("X".repeat(decimals));
        }
        //Обрабатываем еденицы
        if (ones == 9 ) {
            result.append("IX");
        } else if (ones < 9 && ones >=5) {
            result.append("V");
            result.append("I".repeat(ones - 5));
        } else if (ones == 4) {
            result.append("IV");
        } else if (ones < 4) {
            result.append("I".repeat(ones));
        }

        return result.toString();
    }

}