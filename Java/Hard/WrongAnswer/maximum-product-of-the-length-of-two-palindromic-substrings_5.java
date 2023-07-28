class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        long[] dp = new long[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            String sub = "";
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    sub += s.charAt(j);
                }
            }
            if (isPalindrome(sub)) {
                dp[i] = sub.length();
            }
        }
        long res = 0;
        for (int i = 1; i < (1 << n); i++) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (dp[j] > 0 && dp[i ^ j] > 0) {
                    res = Math.max(res, dp[j] * dp[i ^ j]);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}