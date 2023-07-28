class Solution {
    public int countTexts(String pressedKeys) {
        
        int mod = 1000000007;
        int len = pressedKeys.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int cur = pressedKeys.charAt(i-1) - '0';
            dp[i] = dp[i-1];
            if (i > 1 && cur != pressedKeys.charAt(i-2) - '0') {
                dp[i] = (dp[i] + dp[i-2]) % mod;
            }
        }
        return dp[len];
    }
}