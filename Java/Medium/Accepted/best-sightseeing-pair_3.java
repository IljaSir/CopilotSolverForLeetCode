class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int max = values[0] + 0;
        int maxScore = 0;
        for (int i = 1; i < values.length; i++) {
            maxScore = Math.max(maxScore, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return maxScore;
    }
}