class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }
        int[] count = new int[10000];
        for (int card : hand) {
            count[card]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                for (int j = i + 1; j < i + groupSize; j++) {
                    if (count[j] < count[i]) {
                        return false;
                    }
                    count[j] -= count[i];
                }
            }
        }
        return true;
    }
}