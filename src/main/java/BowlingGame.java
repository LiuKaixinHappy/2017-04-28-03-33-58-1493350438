import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        List<Frame> frames = createFrame(bowlingCode);
        int score = 0;
        for (Frame frame : frames) {
            if (frame.getNext_first().equals("/")) {
                score += 10;
                score += Integer.valueOf(frame.getNext_second());
            } else {
                if (frame.getSelf().equals("10")) {
                    score += 10;
                    if (frame.getNext_second().equals("/")) {
                        score += 10;
                    } else {
                        score += Integer.valueOf(frame.getNext_first());
                        score += Integer.valueOf(frame.getNext_second());
                    }
                } else {
                    score += Integer.valueOf(frame.getSelf());
                    score += Integer.valueOf(frame.getNext_first());
                }
            }
        }
        return score;
    }

    private List<Frame> createFrame(String bowlingCode) {
        List<Frame> frames = new ArrayList<>();
        String str[] = bowlingCode.split("\\|");
        // 遍历除了最后一颗球之外的球
        for (int i = 0; i < 9; i++) {
            String self = setSelf(str[i]);
            String next_first;
            String next_second;
            setSelf(str[i]);
            if (str[i].length() == 1) {

                if (str[i + 1].length() == 1) {
                    next_first = "X";
                    if (i == 8) {
                        next_second = str[11].substring(0, 1);
                    } else {
                        next_second = str[i + 2].substring(0, 1);
                    }
                } else {
                    next_first = str[i + 1].substring(0, 1);
                    next_second = str[i + 1].substring(1, 2);
                }
                if (self.equals("X")) {
                    self = "10";
                }
                if (next_first.equals("X")) {
                    next_first = "10";
                }
                if (next_second.equals("X")) {
                    next_second = "10";
                }
                if (self.equals("-")) {
                    self = "0";
                }
                if (next_first.equals("-")) {
                    next_first = "0";
                }
                if (next_second.equals("-")) {
                    next_second = "0";
                }
                frames.add(new Frame(self, next_first, next_second));
            } else {
                next_first = str[i].substring(1, 2);
                next_second = str[i + 1].substring(0, 1);
                if (self.equals("X")) {
                    self = "10";
                }
                if (next_first.equals("X")) {
                    next_first = "10";
                }
                if (next_second.equals("X")) {
                    next_second = "10";
                }
                if (self.equals("-")) {
                    self = "0";
                }
                if (next_first.equals("-")) {
                    next_first = "0";
                }
                if (next_second.equals("-")) {
                    next_second = "0";
                }
                frames.add(new Frame(self, next_first, next_second));
            }
        }
        if (str[9].length() == 1) {
            String self = "X";
            String next_first;
            String next_second;
            if (str[11].length() == 1) {
                next_first = str[11];
                next_second = "0";
            } else {
                next_first = str[11].substring(0, 1);
                next_second = str[11].substring(1, 2);
            }
            if (self.equals("X")) {
                self = "10";
            }
            if (next_first.equals("X")) {
                next_first = "10";
            }
            if (next_second.equals("X")) {
                next_second = "10";
            }
            if (self.equals("-")) {
                self = "0";
            }
            if (next_first.equals("-")) {
                next_first = "0";
            }
            if (next_second.equals("-")) {
                next_second = "0";
            }
            frames.add(new Frame(self, next_first, next_second));
        } else {
            String self = str[9].substring(0, 1);
            String next_first = str[9].substring(1, 2);
            String next_second;
            if (str.length == 12) {
                next_second = str[11].substring(0, 1);
            } else {
                next_second = "0";
            }
            if (self.equals("X")) {
                self = "10";
            }
            if (next_first.equals("X")) {
                next_first = "10";
            }
            if (next_second.equals("X")) {
                next_second = "10";
            }
            if (self.equals("-")) {
                self = "0";
            }
            if (next_first.equals("-")) {
                next_first = "0";
            }
            if (next_second.equals("-")) {
                next_second = "0";
            }
            frames.add(new Frame(self, next_first, next_second));
        }

        return frames;
    }

    private String setSelf(String self) {
        return self.substring(0, 1);
    }

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

        public String getNext_second() {
            return next_second;
        }
    }
}
