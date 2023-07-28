class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int[] good = new int[n];
        int[] bad = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 1) {
                    good[i] |= 1 << j;
                } else if (statements[i][j] == 0) {
                    bad[i] |= 1 << j;
                }
            }
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 0; mask < 1 << n; mask++) {
            if (dp[mask] == -1) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 0) {
                    int next = mask | (1 << i);
                    if (dp[next] == -1 || dp[next] > dp[mask] + Integer.bitCount(good[i] & mask)) {
                        dp[next] = dp[mask] + Integer.bitCount(good[i] & mask);
                    }
                }
            }
        }
        int ans = 0;
        for (int mask = 0; mask < 1 << n; mask++) {
            if (dp[mask] == -1) {
                continue;
            }
            int badCount = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    badCount += Integer.bitCount(bad[i] & mask);
                }
            }
            if (badCount == dp[mask]) {
                ans = Math.max(ans, Integer.bitCount(mask));
            }
        }
        return ans;
    }
}