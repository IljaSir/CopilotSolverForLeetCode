class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int n = binary.length();
        int[] dp = new int[n];
        int[] last = new int[2];
        int MOD = 1000000007;
        Arrays.fill(last, -1);
        dp[0] = 1;
        last[binary.charAt(0) - '0'] = 0;
        for (int i = 1; i < n; i++) {
            int x = binary.charAt(i) - '0';
            if (x == 0) {
                dp[i] = dp[i - 1] * 2 % MOD;
            } else {
                dp[i] = dp[i - 1] * 2 % MOD;
                if (last[0] >= 0) {
                    dp[i] = (dp[i] + dp[last[0]] - 1) % MOD;
                }
            }
            last[x] = i;
        }
        if (last[0] >= 0) {
            dp[n - 1] = (dp[n - 1] + dp[last[0]] - 1) % MOD;
        }
        return dp[n - 1];
    }
}