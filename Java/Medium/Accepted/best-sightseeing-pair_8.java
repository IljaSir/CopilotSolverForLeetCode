class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int max = 0;
        int maxSoFar = values[0];
        for (int i = 1; i < values.length; i++) {
            max = Math.max(maxSoFar + values[i] - i, max);
            maxSoFar = Math.max(maxSoFar, values[i] + i);
        }
        return max;
    }
}