package cz.itnetwork;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static String cislo(int min, int max, String vyzva){
        System.out.println(vyzva);
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[0-9]+");
        String vstup = scanner.nextLine();
        while ( vstup.length()>max || vstup.length()<min || !pattern.matcher(vstup).find() ) {
            System.out.printf("Požadováno číslo délky %d - %d%n",min, max);
            vstup = scanner.nextLine();
        }
        return vstup;
    }
    public static String text(int min, int max, String vyzva){
        System.out.println(vyzva);
        Scanner scanner = new Scanner(System.in);
        //ať pozitivní či negativní, šablona pro text bude vždy problém - hodně znaků
        Pattern pattern = Pattern.compile(".*[0-9 <>$-].*");
        String vstup = scanner.nextLine();
        while ( vstup.length()>max || vstup.length()<min || pattern.matcher(vstup).find() ) {
            System.out.printf("Požadován řetězec délky %d - %d%n",min, max);
            vstup = scanner.nextLine();
        }
        return vstup;
    }
}
