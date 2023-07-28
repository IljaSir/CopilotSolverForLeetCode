class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int ans = 0;
        int n = timeSeries.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                ans += duration;
            } else {
                ans += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
            }
        }
        return ans;
    }
}