class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int maxScore = 0;
        int maxVal = values[0];
        for(int i = 1; i < values.length; i++) {
            maxScore = Math.max(maxScore, maxVal + values[i] - i);
            maxVal = Math.max(maxVal, values[i] + i);
        }
        return maxScore;
    }
}