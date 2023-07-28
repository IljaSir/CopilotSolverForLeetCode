class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        if(timeSeries.length == 0) return 0;
        int ans = 0;
        for(int i = 1; i < timeSeries.length; i++) {
            ans += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return ans + duration;
    }
}