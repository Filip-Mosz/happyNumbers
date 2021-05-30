
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
                    try { //changing Finder.find parameter from int to long won't do
                        isHappy(optionScanner.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("You typed to big number; I have my limitations");
                        separator();
                    }
                    break;
                }
                case ("2"): {
                    System.out.println("Type your number");
                    closestHappy(optionScanner.nextInt());
                    break;
                }
                case ("3"): {
                    int start = 0;
                    int end = 0;
                    do {
                        System.out.println("Type start of range");
                        start = optionScanner.nextInt();
                        System.out.println("Type end of range");
                        end = optionScanner.nextInt();

                    } while (start >= end);

                    happyOfRange(start, end);

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
        System.out.println("'2' type number to find the closest happy number");
        System.out.println("'3' type 2 numbers to find all happy numbers between them");

        System.out.println("'q' or 'exit' to quit program");
    }

    private void isHappy(int number) {

        if (Finder.find(number)) {
            System.out.println("Given number is Happy");
        } else {
            System.out.println("Given number is Sad; sadly");
        }
        separator();
    }

    private void closestHappy(int number) {
        StringBuilder answer = new StringBuilder("The closest happy number");

        if (Finder.closestHappy(number).size() == 1) {
            answer.append(" is: ");
            answer.append(Finder.closestHappy(number));
        } else {
            answer.append("s are: ");
            answer.append(Finder.closestHappy(number));
        }

        System.out.println(answer);
    }

    private void happyOfRange(int start, int end) {
        if (Finder.happyOfRange(start, end).isEmpty()) {
            System.out.println("There are no happy numbers in given range");
        } else {
            System.out.println("These are happy number of range given by you: " +
                    Finder.happyOfRange(start, end));
        }
    }

    private void separator() {
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                System.out.print('-');
            } else if (i == 51) {
                System.out.println(' ');
            } else {
                System.out.print('*');
            }
        }
        System.out.println(System.lineSeparator());
    }

}
