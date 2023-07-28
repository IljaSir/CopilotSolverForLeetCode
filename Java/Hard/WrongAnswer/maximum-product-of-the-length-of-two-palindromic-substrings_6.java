class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        long[] dp = new long[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1 << (s.charAt(i) - 'a');
            for (int j = i - 1; j >= 0; j--) {
                if ((dp[j] & dp[i]) == 0) {
                    dp[j] |= dp[i];
                    res = Math.max(res, (long) (i - j + 1) * (i - j + 1) / 4);
                }
            }
        }
        return res;
    }
}