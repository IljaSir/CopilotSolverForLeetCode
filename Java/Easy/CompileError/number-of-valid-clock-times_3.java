class Solution {
    public int countTime(String time) {
        
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                String h = String.valueOf(i);
                String m = String.valueOf(j);
                if (h.length() == 1) {
                    h = "0" + h;
                }
                if (m.length() == 1) {
                    m = "0" + m;
                }
                if (time.equals(h + ":" + m)) {
                    count++;
                }
            }
        }
        return count;
    }
    public int countTime2(String time) {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                String h = String.valueOf(i);
                String m = String.valueOf(j);
                if (h.length() == 1) {
                    h = "0" + h;
                }
                if (m.length() == 1) {
                    m = "0" + m;
                }
                if (time.equals(h + ":" + m)) {
                    count++;
                }
            }
        }
        return count;
    }
    public int countTime3(String time) {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                String h = String.valueOf(i);
                String m = String.valueOf(j);
                if (h.length() == 1) {
                    h = "0" + h;
                }
                if (m.length() == 1) {
                    m = "0" + m;
                }
                if (time.equals(h + ":" + m)) {
                    count++;
                }
            }
        }
        return count;
    }
    public int countTime4(String time) {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                String h = String.valueOf(i);
                String m = String.valueOf(j);
                if (h.length() == 1) {
                    h = "0" + h;
                }
                if (m.length()
    }
}