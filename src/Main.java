import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanstr = new Scanner(System.in);
        String input = scanstr.nextLine();
        if(input.length()>=3) {
            System.out.println(input.toUpperCase()+" = "+Calc(input));
        } else throw new IllegalArgumentException("throws Exception //т.к. строка не является математической операцией");
    }
    
    public static String Calc(String input) throws IllegalArgumentException {
        char[] znak = input.toCharArray();
        String[] num = input.split("[-/+*]",3);
        if(num.length>2) {
            throw new IllegalArgumentException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        if(num.length<=1) {throw new IllegalArgumentException("throws Exception //т.к. строка не является математической операцией");}
        int n1,n2,rez = 0;
        boolean arabic=true;
        try {
            n1 = Integer.parseInt(num[0].trim());
            n2 = Integer.parseInt(num[1].trim());
        } catch (NumberFormatException e) {
            arabic=false;
            n1 = RomNum.romanToArabic(num[0].trim());
            n2 = RomNum.romanToArabic(num[1].trim()); }

        if ((n1 < 0) || ((n1 > 10) || (n2 < 0)) || (n2 > 10)) {
            throw new InputMismatchException("throws Exception //т.к. формат введенных чисел не удовлетворяет заданию");
        }
        for (int i = 0; i < input.length(); i++) {
            znak[i] = input.charAt(i);
            switch (znak[i]) {
                case '+':
                    rez = (n1 + n2);
                    break;
                case '-':
                    rez = (n1 - n2);
                    break;
                case '*':
                    rez = (n1 * n2);
                    break;
                case '/':
                    try {
                        rez = n1 / n2;
                    } catch (ArithmeticException e) {
                     throw new ArithmeticException("На ноль делить нельзя!");
                    }
               break;

                }
            }
        if(!arabic) {
            return RomNum.arabicToRoman(rez);} else {return String.valueOf(rez);}
    }
}




