class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        
        int m = cost.size();
        int n = cost.get(0).size();
        int[][] dp = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if ((j & (1 << k)) != 0) {
                        sum += cost.get(i).get(k);
                    }
                }
                dp[i][j] = sum;
            }
        }
        int[][] min = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                for (int k = 0; k < n; k++) {
                    if ((j & (1 << k)) != 0) {
                        if (i == 0) {
                            min[i][j] = Math.min(min[i][j], dp[i][j]);
                        } else {
                            min[i][j] = Math.min(min[i][j], min[i - 1][j ^ (1 << k)] + dp[i][j]);
                        }
                    }
                }
            }
        }
        return min[m - 1][(1 << n) - 1];
    }
}