import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomNum {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100);

    private int value;

    private RomNum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static List getReverseSortedValues() {
        return (List)Arrays.stream(values()).sorted(Comparator.comparing((e) -> {
            return e.value;
        }).reversed()).collect(Collectors.toList());
    }

    public static String arabicToRoman(int number) {
        if (number > 0 && number <= 100) {
            List romanNumerals = getReverseSortedValues();
            int i = 0;
            StringBuilder sb = new StringBuilder();

            while(number > 0 && i < romanNumerals.size()) {
                RomNum currentSymbol = (RomNum)romanNumerals.get(i);
                if (currentSymbol.getValue() <= number) {
                    sb.append(currentSymbol.name());
                    number -= currentSymbol.getValue();
                } else {
                    ++i;
                }
            }

            return sb.toString();
        } else {
            throw new IllegalArgumentException("throws Exception //т.к. в римской системе нет отрицательных чисел");
        }
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;
        List romanNumerals = getReverseSortedValues();
        int i = 0;

        while(romanNumeral.length() > 0 && i < romanNumerals.size()) {
            RomNum symbol = (RomNum)romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                ++i;
            }
        }
        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else { return result; }
    }
}