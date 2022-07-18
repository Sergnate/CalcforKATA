import java.util.List;

enum Romes {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100);

    private final int arabic;
    Romes(int arabic) {
        this.arabic = arabic;
    }
    public int getValue() {
        return arabic;
    }

    public static String toRoman(int num) {
        if ((num <= 0) || (num > 100)) {
            throw new IllegalArgumentException("throws Exception //т.к. в римской системе нет отрицательных чисел"); }
        StringBuilder str = new StringBuilder();

        final Romes[] values = Romes.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (num >= values[i].arabic) {
                str.append(values[i]);
                num -= values[i].arabic;
            }
        }
        return str.toString();
    }

    public static int toArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;
          List<Romes> romanNumerals = List.of(Romes.values());
        int i = 0;
            while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            Romes symbol = (Romes) romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else { i++; }
        }
        if (romanNumeral.length() >0) {
            throw new IllegalArgumentException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        return result;
    }
}


