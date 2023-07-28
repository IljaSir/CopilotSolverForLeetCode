class Solution {
    public int countTexts(String pressedKeys) {
        
        int n = pressedKeys.length();
        int[] dp = new int[n];
        int mod = 1000000007;
        int[] counts = new int[10];
        for (int i = 0; i < n; i++) {
            int c = pressedKeys.charAt(i) - '0';
            if (c == 7 || c == 9) {
                counts[c] = counts[c] + 1;
                dp[i] = (dp[i] + counts[c]) % mod;
            } else {
                counts[c] = counts[c] + 1;
                dp[i] = (dp[i] + counts[c]) % mod;
            }
            if (i > 0) {
                int prev = pressedKeys.charAt(i - 1) - '0';
                if (c == prev) {
                    dp[i] = (dp[i] + dp[i - 1]) % mod;
                } else if (prev == 7 && c == 9 || prev == 9 && c == 7) {
                    dp[i] = (dp[i] + dp[i - 1]) % mod;
                }
            }
        }
        return dp[n - 1];
    }
}