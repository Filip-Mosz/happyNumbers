
import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalMenu {

    public void createMenu() {

        Scanner optionScanner = new Scanner(System.in);
        boolean flag = true;

        do {
            showOptions();
            String option = new Scanner(System.in).nextLine();

            switch (option) {
                case ("1"): {
                    System.out.println("Type your number");
//                    Finder.find(optionScanner.nextInt());
                    try {
                    isHappy(optionScanner.nextInt());
                    }catch (InputMismatchException e){
                        System.out.println("You typed to big number; I have my limitations");
                        separator();
                    }
                    break;
                }

                case ("q"):

                case ("exit"): {
                    System.out.println("quitting");
                   flag = false;
                   break;
                }

                default: {
                    System.out.println("command unrecognised, please try again" + System.lineSeparator());

                    break;
                }
            }
        } while (flag);

    }

    private static void showOptions() {
        System.out.println("'1' type number to find if it's happy");

        System.out.println("'q' or 'exit' to quit program");
    }

    private void isHappy(int number){

        if (number > Integer.MAX_VALUE) System.out.println("It's too big");

        if (Finder.find(number)){
            System.out.println("Given number is Happy");
        }else{
            System.out.println("Given number is Sad; sadly");
        }
        separator();
    }

    private void separator(){
        for (int i = 0; i < 52; i++){
            if(i % 2 == 0){
            System.out.print('-');
            } else if(i == 51) {
                System.out.println(' ');
            } else {
                System.out.print('*');
            }
        }
        System.out.println(System.lineSeparator());
    }

}
