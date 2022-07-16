import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanstr = new Scanner(System.in);
        String input = scanstr.nextLine();
        System.out.println(input+"="+Calc(input));}

    public static String Calc(String input){
        char[] znak = input.toCharArray();
        String[] num = input.split("[-/+*]",2);
        int n1 = 0, n2=0, rez = 0;
        boolean arabic=true;
            try {
                n1 = Integer.parseInt(num[0]);
                n2 = Integer.parseInt(num[1]);
                arabic=true;
            } catch (NumberFormatException e) {arabic=false;
              n1 = Integer.parseInt(String.valueOf(RomanNumeral.romanToArabic(num[0])));
              n2 = Integer.parseInt(String.valueOf(RomanNumeral.romanToArabic(num[1])));}
            if (n1 < 0 || n1 > 10 || n2 < 0 || n2 > 10) {
                throw new InputMismatchException("throws Exception //т.к. формат математической операции не удовлетворяет заданию");
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
                            System.out.println("На ноль делить нельзя");
                        }
                        break; }
                }
            if(arabic == false) {String otvet = RomanNumeral.arabicToRoman(Integer.parseInt(String.valueOf(rez)));
            return otvet;} else {String otvet=String.valueOf(rez); return otvet;}
    }
}




