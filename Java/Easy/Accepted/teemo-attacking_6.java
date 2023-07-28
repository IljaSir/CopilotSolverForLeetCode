class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int total = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            int end = timeSeries[i] + duration - 1;
            if (i + 1 < timeSeries.length && end >= timeSeries[i + 1]) {
                total += timeSeries[i + 1] - timeSeries[i];
            } else {
                total += duration;
            }
        }
        return total;
    }
}