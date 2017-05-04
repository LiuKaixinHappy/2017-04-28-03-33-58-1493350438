import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        List<Frame> frames = createFrame(bowlingCode);
        int score = 0;
        for (Frame frame : frames) {
            score += calculateFrameScore(frame);
        }
        return score;
    }

    /**
     * 计算每一格的分数.
     *
     * @param frame 格
     * @return 分数.
     */
    private int calculateFrameScore(Frame frame) {
        if (isSpare(frame.getNext_first())) {
            return 10 + Integer.valueOf(frame.getNext_second());
        }
        if (isStrike(frame.getSelf())) {
            if (isSpare(frame.getNext_second())) {
                return 20;
            }
            return 10 + Integer.valueOf(frame.getNext_first())
                    + Integer.valueOf(frame.getNext_second());
        }
        return Integer.valueOf(frame.getSelf())
                + Integer.valueOf(frame.getNext_first());
    }

    /**
     * 判断是否是strike.
     *
     * @param string 字符串.
     * @return true or false.
     */
    private boolean isStrike(String string) {
        return string.equals("10");
    }

    /**
     * 判断是否是spare.
     *
     * @param string 字符串.
     * @return true or false.
     */
    private boolean isSpare(String string) {
        return string.equals("/");
    }

    /**
     * 创建格子列表,每个格子包含当前球分数和接下来两颗球的分数.
     *
     * @param bowlingCode 保龄球字串.
     * @return 格子列表.
     */
    private List<Frame> createFrame(String bowlingCode) {
        List<Frame> frames = new ArrayList<>();
        String str[] = bowlingCode.split("\\|");
        for (int i = 0; i < 10; i++) {
            String self = setSelf(str[i]);
            String next_first;
            String next_second;
            if (i == 9) {
                next_first = setNextFirst(str[i], str.length == 12 ? str[i + 2] : "0");
                next_second = setNextSecond(str[i], str.length == 12 ? str[i + 2] : "0",
                        str.length == 12 ? str[i + 2] : "0", str.length == 12 ? str[i + 2] : "0");
            } else {
                next_first = setNextFirst(str[i], str[i + 1]);
                next_second = setNextSecond(str[i], str[i + 1],
                        str.length == 12 ? str[i + 2] : "0", str.length == 12 ? str[i + 3] : "0");
            }
            frames.add(new Frame(toNum(self), toNum(next_first), toNum(next_second)));
        }
        return frames;
    }

    /**
     * 将spare和strike转为10和0.
     *
     * @param str 字符串.
     * @return spare：0，strike：10， others：self.
     */
    private String toNum(String str) {
        if (str.equals("X")) {
            return "10";
        }
        if (str.equals("-")) {
            return "0";
        }
        return str;
    }

    private String setSelf(String self) {
        return self.substring(0, 1);
    }

    private String setNextFirst(String self, String nextFirst) {
        if (self.length() == 2) {
            return self.substring(1, 2);
        }
        return nextFirst.substring(0, 1);
    }

    private String setNextSecond(String self, String nextFirst, String nextSecond, String nextThird) {
        if (self.length() == 2) {
            return nextFirst.substring(0, 1);
        }
        if (nextFirst.length() == 1) {
            return nextSecond.isEmpty() ? nextThird.substring(0, 1) : nextSecond.substring(0, 1);
        }
        return nextFirst.substring(1, 2);
    }

    /**
     * 格子类，每个格子包含当前球分数和接下来两颗球的分数.
     */
    private class Frame {
        private String self;
        private String next_first;
        private String next_second;

        Frame(String self, String next_first, String next_second) {
            this.self = self;
            this.next_first = next_first;
            this.next_second = next_second;
        }

        String getSelf() {
            return self;
        }

        String getNext_first() {
            return next_first;
        }

        String getNext_second() {
            return next_second;
        }
    }
}
