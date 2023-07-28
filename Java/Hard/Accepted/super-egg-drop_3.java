class Solution {
    public int superEggDrop(int k, int n) {
        
        int[][] dp = new int[k+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int left = 1, right = j;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int broken = dp[i - 1][mid - 1];
                    int notBroken = dp[i][j - mid];
                    if (broken > notBroken) {
                        dp[i][j] = Math.min(dp[i][j], broken + 1);
                        right = mid - 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], notBroken + 1);
                        left = mid + 1;
                    }
                }
            }
        }
        return dp[k][n];
    }
}