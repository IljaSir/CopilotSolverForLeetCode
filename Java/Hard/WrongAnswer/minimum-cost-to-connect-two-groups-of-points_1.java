class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        
        int n = cost.size();
        int m = cost.get(0).size();
        int[][] dp = new int[n][1 << m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << m); j++) {
                for (int k = 0; k < m; k++) {
                    if ((j & (1 << k)) != 0) {
                        if (i == 0) {
                            dp[i][j] = cost.get(i).get(k);
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j ^ (1 << k)] + cost.get(i).get(k));
                        }
                    }
                }
            }
        }
        int min = dp[n - 1][(1 << m) - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min = Math.min(min, dp[i][(1 << m) - 1] + cost.get(i).get(j));
            }
        }
        return min;
    }
}