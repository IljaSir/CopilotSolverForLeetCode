class Solution {
    public int maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int mask = 0;
                for (int k = i; k <= j; ++k) {
                    mask |= 1 << k;
                }
                if (isPalindrome(s, i, j)) {
                    dp[mask] = j - i + 1;
                }
            }
        }
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) == 1) {
                    dp[i] = Math.max(dp[i], dp[i ^ (1 << j)]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < (1 << n); ++i) {
            if (dp[i] * dp[((1 << n) - 1) ^ i] > ans) {
                ans = dp[i] * dp[((1 << n) - 1) ^ i];
            }
        }
        return ans;
    }
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}