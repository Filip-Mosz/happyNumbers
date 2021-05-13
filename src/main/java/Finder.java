import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Finder {

    public static boolean find(int number) {

        Set<Integer> setOfResults = new HashSet<>();

        if (number == 0) {
            return false;
        }
//add to set
//        if set.add() returns true, keep going
//        if set.add() returns false, number is sad
        int a1 = 0;

        do{
        a1 = squareEachDigitAndSum(number);
            if (a1 == 1){
                return true;
            }
        }while (setOfResults.add(a1));

        return false;
    }

    public static int squareEachDigitAndSum(int number) { //NullPointer caused by using Integer.getInteger() instead of !
// number to String
//        then String.length(), which gives length of table for digits
//        then each character to int and square then to table
//        finally sum everything and return

        String stringifiedNumber = String.valueOf(number);
        int sum = 0;

        for(int i=0; i < stringifiedNumber.length(); i++){
            sum+= squareExceptZero(Integer.parseInt(String.valueOf(stringifiedNumber.charAt(i)))); //here is nullpointer

//            String StringAtI = String.valueOf(stringifiedNumber.charAt(i));
//            int digitAtI = Integer.parseInt(StringAtI);
//            sum = sum+digitAtI;
            System.out.println("digit added");
        }
//wrzuca do listy, ale czy potrzebnie? Zmienna plus wynik metody potęgującej lepszy?
        //tu skończyłem, straciłem wątek :/

        return sum;
    }

    public static int squareExceptZero(int number){
//        easier that way than catching exception
        if(number == 0){
            return 0;
        }
        else {
            return (int) Math.pow(number, 2);
        }
    }

    //liczba jest wesoła gdy:
//    suma kwadratów jej składników w końcu zmierza do 1
//    czuli składa się tylko z 1 i/lub 0

//    Jeśli wynik zacznie się powtarzać liczba jest smutna

//    Czym więc są liczby wesołe? Wybierzmy liczbę naturalną >0 N i rozważmy następujący algorytm.
//
//(1)
//    Oblicz sumę kwadratów cyfr wchodzących w skład zapisu liczby a0 = N i oznacz ją przez a1.
//(2)
//    Jeżeli | a1 = 1, zakończ algorytm. Jeżeli | a1 ≠1, przejdź do następnego kroku.
//(3)
//    Mając już | a0,a1,...,ak dla pewnego | k ⩾ 1, zastosuj krok pierwszy do liczby ak - otrzymasz liczbę |ak+1.
//(4)
//    Jeżeli |ak+1 = ai≠ 1 dla pewnego i ∈{0,...,k}, zakończ algorytm. W przeciwnym przypadku kontynuuj algorytm, przechodząc do kroku (2),
//    który stosujesz dla liczby |ak+1.
//
//Jeżeli w kroku (2) dla pewnego k ⩾1 zachodzi a = 1, k to liczbę N nazwiemy wesołą.
// Jeżeli prawdziwy jest warunek ak+1 = ai ≠1 dla pewnego |i∈{0, ...,k}, to liczbę |N nazwiemy smutną.
// W celu lepszego zrozumienia postawionej wyżej definicji przyjrzyjmy się kilku przykładom.
//
//
//Weźmy liczbę 133. Krok (1) mówi nam "oblicz sumę kwadratów cyfr". W naszym przypadku jest to |12 + 32 + 32 = 19, a więc liczba różna od 1. Warunek z kroku (2) nie jest spełniony, przechodzimy więc do kroku (3). Zgodnie z krokiem (3) obliczamy teraz sumę kwadratów cyfr liczby 19. Otrzymujemy 12 + 92 = 82. Przechodząc do kroku (4), stwierdzamy, że warunek nie jest spełniony, a więc należy wrócić do kroku (2). Wykonując algorytm, otrzymujemy kolejno 68, 100, 1. Ostatecznie po pięciu powtórzeniach otrzymaliśmy jedynkę, co oznacza, że liczba 133 jest wesoła.
}
