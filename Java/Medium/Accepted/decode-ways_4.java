class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int ans1 = Integer.parseInt(s.substring(i, i + 2));
            if (ans1 <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}