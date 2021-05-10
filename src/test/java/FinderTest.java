import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    @Test
    public void isHappy(){
        assertTrue(Finder.find(13));
    }

}