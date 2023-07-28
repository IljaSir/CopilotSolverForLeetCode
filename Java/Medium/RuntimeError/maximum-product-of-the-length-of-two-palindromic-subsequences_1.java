class Solution {
    public int maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = i; j < n; j++) {
                mask |= 1 << s.charAt(j) - 'a';
                dp[mask] = Math.max(dp[mask], j - i + 1);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int mask = 0; mask < 1 << 26; mask++) {
                if ((mask & 1 << i) != 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask ^ 1 << i]);
                }
            }
        }
        int res = 0;
        for (int mask1 = 0; mask1 < 1 << 26; mask1++) {
            int mask2 = ((1 << 26) - 1) ^ mask1;
            res = Math.max(res, dp[mask1] * dp[mask2]);
        }
        return res;
    }
}