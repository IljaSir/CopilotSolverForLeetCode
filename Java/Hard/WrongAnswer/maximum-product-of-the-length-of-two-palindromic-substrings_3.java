class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            String t = "";
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) > 0) {
                    t += s.charAt(j);
                }
            }
            if (isPalindrome(t)) {
                dp[i] = t.length();
            }
        }
        long ans = 0;
        for (int i = 1; i < 1 << n; i++) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                ans = Math.max(ans, (long) dp[j] * dp[i ^ j]);
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}