class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int m = stones.length, n = sum / 2;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            int stone = stones[i - 1];
            for (int j = 0; j <= n; j++) {
                if (j < stone) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stone];
                }
            }
        }

        for (int j = n;; j--) {
            if (dp[m][j]) {
                return sum - 2 * j;
            }
        }
    }
}