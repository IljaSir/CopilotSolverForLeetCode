class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp = new int[days.length];
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = 1; i < days.length; i++) {
            int min = costs[0] + dp[i - 1];
            int j = i - 1;
            while (j >= 0 && days[i] - days[j] < 7) {
                j--;
            }
            if (j >= 0) {
                min = Math.min(min, costs[1] + dp[j]);
            } else {
                min = Math.min(min, costs[1]);
            }
            j = i - 1;
            while (j >= 0 && days[i] - days[j] < 30) {
                j--;
            }
            if (j >= 0) {
                min = Math.min(min, costs[2] + dp[j]);
            } else {
                min = Math.min(min, costs[2]);
            }
            dp[i] = min;
        }
        return dp[days.length - 1];
    }
}