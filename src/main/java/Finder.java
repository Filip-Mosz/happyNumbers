import java.util.HashSet;
import java.util.Set;

public class Finder {

    /**
     * Finds if given number is a "happy number".
     * Which means it eventually reaches 1 when replaced by the sum of the square of each digit.
     *
     * @param number
     * @return true if given number is "happy" else returns false
     */
    public static boolean find(int number) {
//add to set
//        if set.add() returns true, keep going
//        if set.add() returns false, number is sad

        Set<Integer> setOfResults = new HashSet<>();

        if (number == 0) {
            return false;
        }
        int a1 = number;
        int a2 = 0;
        setOfResults.add(number);

        while (true){
        a2 =squareEachDigitAndSum(a1);
            if(!setOfResults.add(a2)){
                return false;
            }else {
                a1 = a2;
            }

            if(a1 == 1){
                return true;
            }
        }

    }

    public static int squareEachDigitAndSum(int number) { //NullPointer caused by using Integer.getInteger() instead of Integer.parseInt()

        String stringifiedNumber = String.valueOf(number);
        int sum = 0;

        for(int i=0; i < stringifiedNumber.length(); i++){
            sum+= squareExceptZero(Integer.parseInt(String.valueOf(stringifiedNumber.charAt(i))));
        }

        return sum;
    }

    private static int squareExceptZero(int number){
//        easier that way than catching exception
        if(number == 0){
            return 0;
        }
        else {
            return (int) Math.pow(number, 2);
        }
    }

}
