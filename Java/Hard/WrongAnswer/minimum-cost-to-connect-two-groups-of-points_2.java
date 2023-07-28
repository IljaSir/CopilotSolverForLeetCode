class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        
        int m = cost.size();
        int n = cost.get(0).size();
        int[][] dp = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j < (1 << n); j++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if ((j & (1 << k)) > 0) {
                    sum += cost.get(0).get(k);
                }
            }
            dp[0][j] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                for (int k = 0; k < n; k++) {
                    if ((j & (1 << k)) > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j ^ (1 << k)] + cost.get(i).get(k));
                    }
                }
            }
        }
        return dp[m - 1][(1 << n) - 1];
    }
}