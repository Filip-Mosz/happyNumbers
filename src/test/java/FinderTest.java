import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    @Test
    public void isHappy() {
        assertTrue(Finder.isHappy(13));
        assertTrue(Finder.isHappy(-13));
    }

    @Test
    public void isSad() {
        assertFalse(Finder.isHappy(85));
    }

    @ParameterizedTest
    @ValueSource(ints = {226, 280, 301, 319, 622, 635, 899, 100})
    public void areHappy(int number) {
        assertTrue(Finder.isHappy(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 30, 191, 200, 380, 403, 505, 999})
    public void areSad(int number) {
        assertFalse(Finder.isHappy(number));
    }

    @Test
    public void isSquareEachDigitAndSumWorking() {
        assertEquals(1, Finder.squareEachDigitAndSum(1));
        assertEquals(26, Finder.squareEachDigitAndSum(15));
        assertEquals(117, Finder.squareEachDigitAndSum(69));
        assertEquals(83, Finder.squareEachDigitAndSum(119));
    }

    @Test
    public void isClosestHappyWorking() {
        assertEquals(List.of(100), Finder.closestHappy(99));
        assertEquals(List.of(989), Finder.closestHappy(982));
        assertEquals(List.of(653, 655), Finder.closestHappy(654));
        assertEquals(List.of(13, 19), Finder.closestHappy(16));
    }

    @Test
    public void isHappyOfRangeWorking() {
        assertEquals(List.of(70, 79, 82, 86, 91, 94, 97, 100, 103), Finder.happyOfRange(69, 104));
        assertEquals(List.of(901, 904, 907, 910, 912, 913, 921,
                923, 931, 932, 937, 940, 946, 964, 970, 973, 989, 998),
                Finder.happyOfRange(900, 999));
        assertEquals(List.of(), Finder.happyOfRange(950, 960));
    }

    @Test
    public void isPrimeAndHappy() {
        assertTrue(Finder.primeAndHappy(7));
        assertTrue(Finder.primeAndHappy(31));
        assertTrue(Finder.primeAndHappy(79));
    }

    @Test
    public void isNotPrimeAndHappy() {
        assertFalse(Finder.primeAndHappy(11));
        assertFalse(Finder.primeAndHappy(37));
        assertFalse(Finder.primeAndHappy(67));
    }

    @Test
    public void isPrimeAndHappyOfRangeWorking() {
        assertEquals(List.of(7, 19, 23, 31, 79, 97), Finder.primeAndHappyOfRange(2, 99));
    }

}