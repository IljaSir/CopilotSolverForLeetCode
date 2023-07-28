class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return mincostTickets(days, costs, 0, dp);
    }
    public int mincostTickets(int[] days, int[] costs, int i, int[] dp) {
        if (i >= days.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        int j = i;
        min = Math.min(min, costs[0] + mincostTickets(days, costs, i + 1, dp));
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        min = Math.min(min, costs[1] + mincostTickets(days, costs, j, dp));
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        min = Math.min(min, costs[2] + mincostTickets(days, costs, j, dp));
        dp[i] = min;
        return min;
    }
}