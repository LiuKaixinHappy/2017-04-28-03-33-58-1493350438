import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void test_all_strike() throws Exception {
        String bowlingCode = "X|X|X|X|X|X|X|X|X|X||XX";           //300
        assertEquals(300,  new BowlingGame().getBowlingScore(bowlingCode));
    }

    @Test
    public void test_second_spare() throws Exception {
        String bowlingCode = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";  //150
        assertEquals(150, new BowlingGame().getBowlingScore(bowlingCode));
    }

    @Test
    public void test_second_miss() throws Exception {
        String bowlingCode = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";   //90
        assertEquals(90, new BowlingGame().getBowlingScore(bowlingCode));

    }

    @Test
    public void test_other_situation() throws Exception {
        String bowlingCode = "X|7/|9-|X|-8|8/|-6|X|X|X||81";      //167
        assertEquals(167, new BowlingGame().getBowlingScore(bowlingCode));

    }

    @Test
    public void test_only_last_not_miss_situation() throws Exception {
        String bowlingCode = "--|--|--|--|--|--|--|--|--|X||81";      //19
        assertEquals(19, new BowlingGame().getBowlingScore(bowlingCode));

    }

    @Test
    public void test_no_strike_and_spare_situation() throws Exception {
        String bowlingCode = "12|23|34|45|56|67|78|89|88|88||";      //112
        assertEquals(112, new BowlingGame().getBowlingScore(bowlingCode));

    }
}

