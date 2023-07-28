class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int max = 0;
        int best = values[0];
        for (int i = 1; i < values.length; i++) {
            max = Math.max(max, values[i] - i + best);
            best = Math.max(best, values[i] + i);
        }
        return max;
    }
}