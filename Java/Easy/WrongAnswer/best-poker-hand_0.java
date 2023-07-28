class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        int[] rankCount = new int[14];
        int[] suitCount = new int[4];
        for (int i = 0; i < 5; i++) {
            rankCount[ranks[i]]++;
            suitCount[suits[i] - 'a']++;
        }
        boolean flush = false;
        for (int i = 0; i < 4; i++) {
            if (suitCount[i] == 5) {
                flush = true;
                break;
            }
        }
        boolean threeOfAKind = false;
        boolean pair = false;
        for (int i = 1; i <= 13; i++) {
            if (rankCount[i] == 3) {
                threeOfAKind = true;
            }
            if (rankCount[i] == 2) {
                pair = true;
            }
        }
        if (flush) {
            return "Flush";
        }
        if (threeOfAKind) {
            return "Three of a Kind";
        }
        if (pair) {
            return "Pair";
        }
        return "High Card";
    }
}