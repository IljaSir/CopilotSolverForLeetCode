class Solution {
    public int idealArrays(int n, int maxValue) {
        
        long mod = 1000000007;
        int[] dp = new int[maxValue + 1];
        int[] sum = new int[maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[i] = 1;
            sum[i] = (sum[i - 1] + dp[i]) % mod;
        }
        for (int i = 2; i <= n; i++) {
            int[] newDp = new int[maxValue + 1];
            int[] newSum = new int[maxValue + 1];
            for (int j = 1; j <= maxValue; j++) {
                newDp[j] = (int) (sum[j] - sum[j / 2]);
                newSum[j] = (newSum[j - 1] + newDp[j]) % mod;
            }
            dp = newDp;
            sum = newSum;
        }
        return (int) ((sum[maxValue] - sum[0] + mod) % mod);
    }
}