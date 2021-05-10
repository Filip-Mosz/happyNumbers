import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    @Test
    public void isHappy(){
        assertTrue(Finder.find(13));
    }

    @Test
    public void isSad(){
        assertFalse(Finder.find(85));
    }

    @ParameterizedTest
    @ValueSource(ints={226, 280, 301, 319, 622, 635, 899, 100})
    public void areHappy(int number){
        assertTrue(Finder.find(number));
    }

    @ParameterizedTest
    @ValueSource(ints={0, 5, 30, 191, 200, 380, 403, 505, 999})
    public void areSad(int number){
        assertFalse(Finder.find(number));
    }

}