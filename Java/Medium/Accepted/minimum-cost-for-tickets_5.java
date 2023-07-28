class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp = new int[days.length];
        int[] durations = new int[]{1, 7, 30};
        for (int i = 0; i < days.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                int cost = costs[j];
                int duration = durations[j];
                int prev = i - 1;
                while (prev >= 0 && days[i] - days[prev] < duration) {
                    prev--;
                }
                if (prev < 0) {
                    dp[i] = Math.min(dp[i], cost);
                } else {
                    dp[i] = Math.min(dp[i], dp[prev] + cost);
                }
            }
        }
        return dp[days.length - 1];
    }
}