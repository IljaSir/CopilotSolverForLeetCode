class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int total = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            int end = timeSeries[i] + duration;
            if (i < timeSeries.length - 1) {
                end = Math.min(end, timeSeries[i + 1]);
            }
            total += end - timeSeries[i];
        }
        return total;
    }
}