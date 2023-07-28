class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        int m = piles.get(0).size();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = piles.get(i).get(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int left = 0;
                int right = 0;
                if (j - 1 >= 0) {
                    left = dp[i][j - 1];
                }
                if (j + 1 < m) {
                    right = dp[i][m - 1] - dp[i][j + 1];
                }
                int sum = left + right;
                if (j % 2 == 0) {
                    ans += sum;
                }
            }
        }
        return ans;
    }
}
    }
}