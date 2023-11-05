import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Bilietas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bandymai = 0;
        int numeris = 0;

        while (numeris == 0) {
            System.out.print("Įveskite savo bilieto šešių skaičių numerį: ");
            int ivestas = scanner.nextInt();
            bandymai++;

            if (LaimingasNr(ivestas)) {
                numeris = ivestas;
            }
        }
        System.out.println("Jūsų bilietas laimingas! " );
        System.out.println("Laimingo bilieto numeris: " + numeris);
        System.out.println("Atlikta bandymų: " + bandymai);
    }
    public static boolean LaimingasNr(int bilietas){
            String skaiciai = String.valueOf(bilietas);

        if (skaiciai.length() != 6) {
            System.out.println("Blogai suvestas bilieto numeris!" );
            return false;
        }
        Set<Character> uniqueDigits = new HashSet<>();
        int a = 0;
        int b = 0;

        for (int i = 0; i < 6; i++) {
            char digit = skaiciai.charAt(i);

            if (uniqueDigits.contains(digit)) {
                return false;
            }

            uniqueDigits.add(digit);
            if (i < 3) {
                a += Character.getNumericValue(digit);
            } else {
                b += Character.getNumericValue(digit);
            }
        }
        return a == b;
    }
}