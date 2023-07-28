class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        int[] count = new int[14];
        for (int i : ranks) {
            count[i]++;
        }
        int max = 0;
        for (int i : count) {
            max = Math.max(max, i);
        }
        if (max == 4) {
            return "Four of a Kind";
        } else if (max == 3) {
            for (int i : count) {
                if (i == 2) {
                    return "Full House";
                }
            }
            return "Three of a Kind";
        } else if (max == 2) {
            int count2 = 0;
            for (int i : count) {
                if (i == 2) {
                    count2++;
                }
            }
            if (count2 == 2) {
                return "Two Pairs";
            }
            return "Pair";
        }
        Arrays.sort(ranks);
        if (ranks[0] == 1) {
            ranks[0] = 14;
        }
        for (int i = 0; i < 4; i++) {
            if (ranks[i] + 1 != ranks[i + 1]) {
                break;
            }
            if (i == 3) {
                return "Straight";
            }
        }
        for (int i = 0; i < 4; i++) {
            if (suits[i] != suits[i + 1]) {
                break;
            }
            if (i == 3) {
                return "Flush";
            }
        }
        return "High Card";
    }
}