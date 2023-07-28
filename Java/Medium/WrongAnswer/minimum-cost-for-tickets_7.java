class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int dp[] = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = costs[0];
        for (int i = 1; i < days.length; i++) {
            int day = days[i];
            dp[i] = dp[i - 1] + costs[0];
            int j = i - 1;
            while (j >= 0 && days[j] + 6 >= day) {
                j--;
            }
            if (j >= 0) {
                dp[i] = Math.min(dp[i], dp[j] + costs[1]);
            } else {
                dp[i] = Math.min(dp[i], costs[1]);
            }
            while (j >= 0 && days[j] + 29 >= day) {
                j--;
            }
            if (j >= 0) {
                dp[i] = Math.min(dp[i], dp[j] + costs[2]);
            } else {
                dp[i] = Math.min(dp[i], costs[2]);
            }
        }
        return dp[days.length - 1];
    }
}