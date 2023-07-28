class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        if (s.charAt(n - 1) == 'a') {
            dp[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                dp[i] = dp[i + 1] + 1;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        int res = dp[0];
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                b++;
            }
            res = Math.min(res, b + dp[i + 1]);
        }
        return res;
    }
}