class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < n; ++i) {
            dp[1 << i] = 1;
        }
        for (int mask = 1; mask < (1 << n); ++mask) {
            if (dp[mask] == 0) {
                continue;
            }
            int[] seen = new int[n];
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }
                for (int j = 0; j < n; ++j) {
                    if ((mask & (1 << j)) != 0) {
                        continue;
                    }
                    if (statements[i][j] == 0) {
                        ++seen[j];
                    } else if (statements[i][j] == 1) {
                        --seen[j];
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    continue;
                }
                if (seen[i] == dp[mask]) {
                    dp[mask | (1 << i)] = dp[mask] + 1;
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}