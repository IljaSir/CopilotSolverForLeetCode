class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int n = values.length;
        int max = 0;
        int max_i = values[0];
        for (int j = 1; j < n; j++) {
            max = Math.max(max, max_i + values[j] - j);
            max_i = Math.max(max_i, values[j] + j);
        }
        return max;
    }
}