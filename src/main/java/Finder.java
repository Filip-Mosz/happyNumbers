import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Finder {

    /**
     * Finds if given number is a "happy number".
     * Which means it eventually reaches 1 when replaced by the sum of the square of each digit.
     *
     * @param number number given by user of method
     * @return true if given number is "happy" else returns false
     */
    public static boolean isHappy(int number) {
//add to set
//        if set.add() returns true, keep going
//        if set.add() returns false, number is sad

        Set<Integer> setOfResults = new HashSet<>();

        if (number == 0) {
            return false;
        }
        if (number == 1) {
            return true;
        }
        int a1 = number;
        setOfResults.add(number);

        while (true) {
            int a2 = squareEachDigitAndSum(a1);
            if (!setOfResults.add(a2)) {
                return false;
            } else {
                a1 = a2;
            }

            if (a1 == 1) {
                return true;
            }
        }

    }

    public static int squareEachDigitAndSum(int number) { //NullPointer caused by using Integer.getInteger() instead of Integer.parseInt()

        String stringifiedNumber = String.valueOf(number);
        int sum = 0;

        for (int i = 0; i < stringifiedNumber.length(); i++) {
            int element;
            try {
                element = Integer.parseInt(String.valueOf(stringifiedNumber.charAt(i)));
            } catch (NumberFormatException e) {
                element = 0;
//      negative number squared gives positive number so it's OK
            }
            sum += squareExceptZero(element);
        }

        return sum;
    }

    private static int squareExceptZero(int number) {
//        easier that way than catching exception
        if (number == 0) {
            return 0;
        } else {
            return (int) Math.pow(number, 2);
        }
    }


    /**
     * searches for closest happy number to that given by user
     *
     * @param number number given by user of method
     * @return List in case if there would be 2 numbers that matches condition
     */
    public static List<Integer> closestHappy(int number) {
//        it may use Tuple, but List is already coded

        int higher = number + 1;
        int lower = number - 1;
        List<Integer> result = new LinkedList<>();

        if (isHappy(number)) {
            return List.of(number);
        }

        while (true) {
            if (isHappy(lower)) {
                result.add(lower);
            }
            if (isHappy(higher)) {
                result.add(higher);
            }

            if (result.isEmpty()) {
                higher += 1;
                lower -= 1;
            } else {
                return result;
            }

        }

    }


    public static List<Integer> happyOfRange(int start, int end) {
        List<Integer> result = new LinkedList<>();

        for (int i = start; i <= end; i++) {
            if (isHappy(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean isPrimeAndHappy(int number) {
        return isHappy(number) && Prime.isPrime(number);
    }

    public static List<Integer> closestPrimeHappy(int number){
        int higher = number + 1;
        int lower = number - 1;
        List<Integer> result = new LinkedList<>();

        if (isPrimeAndHappy(number)) {
            return List.of(number);
        }

        while (true) {
            if (isPrimeAndHappy(lower)) {
                result.add(lower);
            }
            if (isPrimeAndHappy(higher)) {
                result.add(higher);
            }

            if (result.isEmpty()) {
                higher += 1;
                lower -= 1;
            } else {
                return result;
            }

        }

    }


    public static List<Integer> primeAndHappyOfRange(int start, int end) {
        List<Integer> result = new LinkedList<>();

        List<Integer> happyNumbers = happyOfRange(start, end);

        for (Integer happyNumber : happyNumbers) {
            if (Prime.isPrime(happyNumber)) {
                result.add(happyNumber);
            }
        }

        return result;
    }

}
