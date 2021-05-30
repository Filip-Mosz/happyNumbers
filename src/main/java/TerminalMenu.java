
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
                    int start;
                    int end;
                    do {
                        System.out.println("Type start of range");
                        start = optionScanner.nextInt();
                        System.out.println("Type end of range");
                        end = optionScanner.nextInt();

                    } while (start >= end);

                    happyOfRange(start, end);

                    break;
                }
                case ("4"): {
                    System.out.println("Type thy number");
                    primeAndHappy(optionScanner.nextInt());
                    break;
                }
                case ("5"): {
                    System.out.println("Type your number");
                    closestPrimeHappy(optionScanner.nextInt());
                    break;
                }
                case ("6"): {
                    int start;
                    int end;
                    do {
                        System.out.println("Type start of range");
                        start = optionScanner.nextInt();
                        System.out.println("Type end of range");
                        end = optionScanner.nextInt();

                    } while (start >= end);

                    primeAndHappyOfRange(start, end);

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
        System.out.println("'4' type number to find if it's prime and happy" );
        System.out.println("'5' type number to find the closest prime happy number");
        System.out.println("'6' type 2 numbers to find all happy prime numbers between them");

        System.out.println("'q' or 'exit' to quit program");
    }

    private void isHappy(int number) {

        if (Finder.isHappy(number)) {
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
        } else {
            answer.append("s are: ");
        }
        answer.append(Finder.closestHappy(number));

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

    private void primeAndHappy(int number){
        if (Finder.isPrimeAndHappy(number)) {
            System.out.println("Given number is Happy");
        } else {
            System.out.println("Given number is Sad; sadly");
        }
        separator();
    }

    private void closestPrimeHappy(int number) {
        StringBuilder answer = new StringBuilder("The closest prime happy number");

        if (Finder.closestPrimeHappy(number).size() == 1) {
            answer.append(" is: ");
        } else {
            answer.append("s are: ");
        }
        answer.append(Finder.closestPrimeHappy(number));

        System.out.println(answer);
    }

    private void primeAndHappyOfRange(int start, int end) {
        if (Finder.primeAndHappyOfRange(start, end).isEmpty()) {
            System.out.println("There are no happy prime numbers in given range");
        } else {
            System.out.println("These are happy prime number of range given by you: " +
                    Finder.primeAndHappyOfRange(start, end));
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
