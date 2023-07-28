class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i >= 1 ? dp[i - 1] : 0;
            int right = dp[n - 1] - dp[i];
            res = Math.min(res, left + (n - 1 - i + 1 - right) - right);
        }
        return res;
    }
}