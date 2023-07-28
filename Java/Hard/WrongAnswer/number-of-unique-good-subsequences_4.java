class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int n = binary.length();
        int mod = 1000000007;
        int[] dp = new int[n];
        dp[0] = binary.charAt(0) == '0' ? 1 : 2;
        int one = binary.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (binary.charAt(i) == '0') {
                dp[i] = dp[i - 1] * 2 % mod;
            } else {
                dp[i] = (dp[i - 1] * 2 - dp[i - 1] + 1 + mod) % mod;
                one++;
            }
        }
        return (dp[n - 1] + one) % mod;
    }
}