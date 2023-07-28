class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        
        int n = cost.size();
        int m = cost.get(0).size();
        int[][] dp = new int[1 << n][m + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                if ((j & (1 << i)) > 0) {
                    for (int k = 0; k < m; k++) {
                        dp[j][k + 1] = Math.min(dp[j][k + 1], dp[j ^ (1 << i)][k] + cost.get(i).get(k));
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << n); i++) {
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                tmp = Math.max(tmp, cost.get(Integer.numberOfTrailingZeros(i)).get(j));
            }
            ans = Math.min(ans, dp[i][m] + tmp * (n - Integer.bitCount(i)));
        }
        return ans;
    }
}