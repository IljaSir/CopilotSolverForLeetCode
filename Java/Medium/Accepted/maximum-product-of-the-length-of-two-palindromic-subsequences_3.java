class Solution {
    public int maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            String sub = "";
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    sub += s.charAt(j);
                }
            }
            if (isPalindromic(sub)) {
                dp[i] = sub.length();
            }
        }
        int ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = i + 1; j < 1 << n; j++) {
                if ((i & j) == 0) {
                    ans = Math.max(ans, dp[i] * dp[j]);
                }
            }
        }
        return ans;
    }
    private boolean isPalindromic(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}