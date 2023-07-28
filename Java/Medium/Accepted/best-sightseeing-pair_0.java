class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int max = values[0];
        int res = 0;
        for (int j = 1; j < values.length; j++) {
            res = Math.max(res, max + values[j] - j);
            max = Math.max(max, values[j] + j);
        }
        return res;
    }
}