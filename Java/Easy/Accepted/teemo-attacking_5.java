class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int res = 0;
        int n = timeSeries.length;
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < n - 1; i++) {
            res += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return res + duration;
    }
}