class Solution {
    public int numPermsDISequence(String s) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }
        for (char c : s.toCharArray()) {
            int[] dp2 = new int[n + 1];
            if (c == 'D') {
                for (int i = 0; i < n; i++) {
                    dp2[i] = dp[i + 1];
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    dp2[i] = dp[i - 1];
                }
            }
            for (int i = 1; i <= n; i++) {
                dp2[i] = (dp2[i] + dp2[i - 1]) % 1_000_000_007;
            }
            dp = dp2;
        }
        return dp[n];
    }
}