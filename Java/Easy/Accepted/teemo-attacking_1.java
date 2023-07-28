class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int time = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == timeSeries.length - 1) {
                time += duration;
            } else {
                time += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
            }
        }
        return time;
    }
}