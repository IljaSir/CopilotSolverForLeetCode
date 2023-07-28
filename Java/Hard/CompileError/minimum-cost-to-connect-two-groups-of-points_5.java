class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        
        int m = cost.size();
        int n = cost.get(0).size();
        int[][] dp = new int[m][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][1 << j] = cost.get(i).get(j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) != 0) {
                        continue;
                    }
                    dp[i][mask | (1 << j)] = Math.min(dp[i][mask | (1 << j)], dp[i][mask] + cost.get(i).get(j));
                }
            }
        }
        int[][] dp2 = new int[1 << n][1 << n];
        for (int[] row : dp2) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        dp2[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int mask1 = 0; mask1 < (1 << n); mask1++) {
                for (int mask2 = 0; mask2 < (1 << n); mask2++) {
                    if (dp2[mask1][mask2] == Integer.MAX_VALUE / 2) {
                        continue;
                    }
                    for (int j = 0; j < n; j++) {
                        if ((mask2 & (1 << j)) != 0) {
                            continue;
                        }
                        dp2[mask1 | (1 << j)][mask2 | (1 << j)] = Math.min(dp2[mask1 | (1 << j)][mask2 | (1 << j)], dp2[mask1][mask2] + cost.get(i).get(j));
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << n); mask++) {
            res = Math.min(res, dp2[(1
    }
}