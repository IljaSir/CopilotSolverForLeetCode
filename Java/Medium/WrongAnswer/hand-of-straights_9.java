class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        int numGroups = n / groupSize;
        int[] groupCount = new int[numGroups];
        int groupIdx = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (hand[i] != prev) {
                groupIdx = 0;
                prev = hand[i];
            }
            if (groupIdx == numGroups) {
                return false;
            }
            groupCount[groupIdx]++;
            if (groupCount[groupIdx] == groupSize) {
                groupIdx++;
            }
        }
        return true;
    }
}