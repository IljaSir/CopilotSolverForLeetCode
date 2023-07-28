class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    dp[i] = j;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (s.charAt(dp[i]) == s.charAt(dp[i] - Integer.bitCount(i) + 1)) {
                for (int j = 0; j < i; j++) {
                    if ((i & j) == 0 && s.charAt(dp[j]) == s.charAt(dp[j] - Integer.bitCount(j) + 1)) {
                        ans = Math.max(ans, (long) Integer.bitCount(i) * Integer.bitCount(j));
                    }
                }
            }
        }
        return ans;
    }
}