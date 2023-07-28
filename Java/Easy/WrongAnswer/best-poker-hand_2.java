class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        int[] num = new int[14];
        int[] suit = new int[4];
        for (int i = 0; i < ranks.length; i++) {
            num[ranks[i]]++;
            suit[suits[i] - 'a']++;
        }
        int maxNum = 0;
        for (int i = 0; i < num.length; i++) {
            maxNum = Math.max(maxNum, num[i]);
        }
        int maxSuit = 0;
        for (int i = 0; i < suit.length; i++) {
            maxSuit = Math.max(maxSuit, suit[i]);
        }
        if (maxSuit == 5) {
            return "Flush";
        } else if (maxNum == 3) {
            return "Three of a Kind";
        } else if (maxNum == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}