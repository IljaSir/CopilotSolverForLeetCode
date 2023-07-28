class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int mod = 1000000007;
        int n = binary.length();
        int[] dp = new int[n];
        dp[0] = binary.charAt(0) == '0' ? 1 : 2;
        int[] last = new int[2];
        last[0] = 0;
        last[1] = binary.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (binary.charAt(i) == '0') {
                dp[i] = (dp[i - 1] + 1) % mod;
            } else {
                dp[i] = (dp[i - 1] * 2 - dp[last[0]] + 2) % mod;
            }
            last[binary.charAt(i) - '0'] = i;
        }
        return (dp[n - 1] + mod) % mod;
    }
}