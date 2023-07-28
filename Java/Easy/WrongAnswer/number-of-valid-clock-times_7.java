class Solution {
    public int countTime(String time) {
        
        int h = 0;
        int m = 0;
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            if (chars[1] == '?') {
                h = 24;
            } else if (chars[1] >= '0' && chars[1] <= '3') {
                h = 2;
            } else {
                h = 1;
            }
        } else if (chars[0] == '0' || chars[0] == '1') {
            if (chars[1] == '?') {
                h = 10;
            } else {
                h = 1;
            }
        } else if (chars[0] == '2') {
            if (chars[1] == '?') {
                h = 4;
            } else if (chars[1] >= '0' && chars[1] <= '3') {
                h = 1;
            }
        }
        if (chars[3] == '?') {
            if (chars[4] == '?') {
                m = 60;
            } else {
                m = 10;
            }
        } else if (chars[4] == '?') {
            m = 10;
        } else {
            m = 1;
        }
        return h * m;
    }
    public int numberOfValidClockTimes(String time) {
        int count = 0;
        for (int i = 0; i < 1440; i++) {
            String h = String.valueOf(i / 60);
            String m = String.valueOf(i % 60);
            if (h.length() == 1) {
                h = "0" + h;
            }
            if (m.length() == 1) {
                m = "0" + m;
            }
            String clock = h + ":" + m;
            if (countTime(clock) == countTime(time)) {
                count++;
            }
        }
        return count;
    }
}