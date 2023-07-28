class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int n = timeSeries.length;
        if (n == 0) return 0;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        return sum + duration;
    }
}