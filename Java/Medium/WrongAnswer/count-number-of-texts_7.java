class Solution {
    public int countTexts(String pressedKeys) {
        
        int m = 1000000007;
        int n = pressedKeys.length();
        int[] dp = new int[n];
        int[] count = new int[10];
        count[2] = 3;
        count[3] = 3;
        count[4] = 3;
        count[5] = 3;
        count[6] = 3;
        count[7] = 4;
        count[8] = 3;
        count[9] = 4;
        dp[0] = count[pressedKeys.charAt(0) - '0'];
        for (int i = 1; i < n; i++) {
            int c = pressedKeys.charAt(i) - '0';
            int d = pressedKeys.charAt(i - 1) - '0';
            dp[i] = (dp[i - 1] * count[c]) % m;
            if (d == c) {
                dp[i] = (dp[i] + (i >= 2 ? dp[i - 2] : 1)) % m;
            }
        }
        return dp[n - 1];
    }
}