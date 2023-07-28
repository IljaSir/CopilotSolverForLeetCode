class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp = new int[days.length];
        int[] lasts = new int[3];
        int[] durations = new int[] {1, 7, 30};
        for (int i = 0; i < days.length; i++) {
            int day = days[i];
            for (int j = 0; j < 3; j++) {
                while (lasts[j] < i && day - days[lasts[j]] >= durations[j]) {
                    lasts[j]++;
                }
                int cost = costs[j] + (lasts[j] == 0 ? 0 : dp[lasts[j] - 1]);
                dp[i] = i == 0 ? cost : Math.min(dp[i - 1], cost);
            }
        }
        return dp[days.length - 1];
    }
}