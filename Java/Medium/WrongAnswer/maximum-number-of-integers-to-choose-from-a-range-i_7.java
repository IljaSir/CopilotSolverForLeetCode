class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        int[] dp = new int[maxSum+1];
        Arrays.fill(dp, 1);
        for (int b : banned) {
            dp[b] = -1;
        }
        for (int i = 1; i <= maxSum; i++) {
            if (dp[i] == -1) {
                dp[i] = 0;
            } else {
                dp[i] += dp[i-1];
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int sum = maxSum - i;
            if (sum < 0) {
                break;
            }
            if (dp[sum] == -1) {
                continue;
            }
            res += dp[sum];
        }
        return res;
    }
}