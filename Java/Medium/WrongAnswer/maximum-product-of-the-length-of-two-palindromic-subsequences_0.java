class Solution {
    public int maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            int len = 0;
            int i = 0;
            while (i < n && ((mask >> i) & 1) == 0) {
                i++;
            }
            int j = n - 1;
            while (j >= 0 && ((mask >> j) & 1) == 0) {
                j--;
            }
            if (s.charAt(i) == s.charAt(j)) {
                dp[mask] = dp[mask ^ (1 << i) ^ (1 << j)];
                if (dp[mask] != -1) {
                    dp[mask] += 2;
                }
            }
            if (dp[mask] == -1) {
                for (int k = i + 1; k < j; k++) {
                    if (((mask >> k) & 1) == 1) {
                        dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << k)]);
                    }
                }
            }
        }
        int ans = 0;
        for (int mask1 = 0; mask1 < (1 << n); mask1++) {
            if (dp[mask1] != -1) {
                ans = Math.max(ans, dp[mask1] * dp[((1 << n) - 1) ^ mask1]);
            }
        }
        return ans;
    }
}