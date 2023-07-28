class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    sum += tasks[i];
                }
            }
            int s = sum / sessionTime;
            if (sum % sessionTime != 0) {
                s++;
            }
            dp[mask] = s + dp[mask];
            for (int i = mask; i > 0; i = (i - 1) & mask) {
                dp[mask] = Math.min(dp[mask], dp[i] + dp[mask ^ i]);
            }
        }
        return dp[(1 << n) - 1];
    }
}