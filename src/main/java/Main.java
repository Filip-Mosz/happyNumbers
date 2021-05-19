

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TerminalMenu menu = new TerminalMenu();

        System.out.println("Hello" + System.lineSeparator());

        System.out.println("Type a number and I will tell you if it is a Happy number.");
//        int scannedResult = scan.nextInt();
//
//        if(Finder.find(scannedResult)){
//            System.out.println("Given number is Happy");
//        }else{
//            System.out.println("Given number is Sad; sadly");
//        }

        menu.createMenu();

    }

    //helpful: http://www.deltami.edu.pl/temat/matematyka/teoria_liczb/2015/03/31/Wesole_liczby/
}
