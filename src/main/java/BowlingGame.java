import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        List<Frame> frames = createFrame(bowlingCode);


        int score = 300;

        return score;
    }

    private List<Frame> createFrame(String bowlingCode) {
        List<Frame> frames = new ArrayList<Frame>();
//        String frames[] = bowlingCode.split("\\|");
        return frames;
    }

    private class Frame {
        String self;
        String next_first;
        String next_second;

        public Frame(String self, String next_first, String next_second) {
            this.self = self;
            this.next_first = next_first;
            this.next_second = next_second;
        }

        public String getSelf() {
            return self;
        }

        public String getNext_first() {
            return next_first;
        }

        public String getNext_second() {
            return next_second;
        }
    }
}
