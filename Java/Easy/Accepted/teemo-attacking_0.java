class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int result = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == timeSeries.length - 1) {
                result += duration;
            } else {
                result += Math.min(duration, timeSeries[i+1] - timeSeries[i]);
            }
        }
        return result;
    }
}