class Solution {
    public int countTexts(String pressedKeys) {
        
        int[] dp = new int[pressedKeys.length()];
        int mod = 1000000007;
        dp[0] = 1;
        for (int i = 1; i < pressedKeys.length(); i++) {
            dp[i] = dp[i - 1];
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1)) {
                dp[i] = (dp[i] + dp[Math.max(0, i - 2)]) % mod;
            }
        }
        return dp[pressedKeys.length() - 1];
    }
}