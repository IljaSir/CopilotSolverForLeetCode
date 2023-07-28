class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int max = 0;
        int cur = 0;
        for (int i = 0; i < values.length; i++) {
            max = Math.max(max, cur + values[i] - i);
            cur = Math.max(cur, values[i] + i);
        }
        return max;
    }
}