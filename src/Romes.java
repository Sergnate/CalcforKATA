import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public enum Romes {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);
    private final int arabic;
    Romes(int arabic) {
        this.arabic = arabic;
    }
    public int getValue() {
        return arabic;
    }
    public static List getReverseRomes() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((Romes e) -> e.arabic).reversed())
                .collect(Collectors.toList());
    }

    public static String toRoman(int number) {
        if ((number <=0) || (number > 100)) {
            throw new InputMismatchException("throws Exception //т.к. в римской системе нет отрицательных чисел"); }

        List romNum = Romes.getReverseRomes();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romNum.size())) {
            Romes symbol = (Romes) romNum.get(i);
            if (symbol.getValue() <= number) {
                sb.append(symbol.name());
                number -= symbol.getValue();
            } else {
                i++; }
        }
        return sb.toString();}
    public static int toArabic(String input) {
        String romNum = input.toUpperCase();
        int result = 0;

        List romNums = Romes.getReverseRomes();

        int i = 0;

        while ((romNum.length() > 0) && (i < romNums.size())) {
            Romes symbol = (Romes) romNums.get(i);
            if (romNum.startsWith(symbol.name())) {
                result += symbol.getValue();
                romNum = romNum.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romNum.length() >0) {
            throw new IllegalArgumentException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        return result;}
}
