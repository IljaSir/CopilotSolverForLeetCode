class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        int[] count = new int[13];
        for (int r : ranks) {
            count[r - 1]++;
        }
        int[] suit = new int[4];
        for (char s : suits) {
            suit[s - 'a']++;
        }
        // flush
        int maxSuit = 0;
        for (int s : suit) {
            maxSuit = Math.max(maxSuit, s);
        }
        if (maxSuit >= 5) {
            return "Flush";
        }
        // three of a kind
        for (int c : count) {
            if (c >= 3) {
                return "Three of a Kind";
            }
        }
        // pair
        int pair = 0;
        for (int c : count) {
            if (c >= 2) {
                pair++;
            }
        }
        if (pair >= 2) {
            return "Two Pairs";
        }
        if (pair == 1) {
            return "Pair";
        }
        return "High Card";
    }
}