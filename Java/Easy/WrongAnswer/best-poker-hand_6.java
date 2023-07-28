class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        int[] count = new int[13];
        for (int i : ranks) {
            count[i-1]++;
        }
        int[] suit = new int[4];
        for (char c : suits) {
            if (c == 'a') {
                suit[0]++;
            } else if (c == 'b') {
                suit[1]++;
            } else if (c == 'c') {
                suit[2]++;
            } else if (c == 'd') {
                suit[3]++;
            }
        }
        boolean flush = false;
        for (int i : suit) {
            if (i == 5) {
                flush = true;
                break;
            }
        }
        boolean three = false;
        boolean pair = false;
        for (int i : count) {
            if (i == 3) {
                three = true;
            }
            if (i == 2) {
                pair = true;
            }
        }
        if (flush) {
            return "Flush";
        } else if (three) {
            return "Three of a Kind";
        } else if (pair) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}