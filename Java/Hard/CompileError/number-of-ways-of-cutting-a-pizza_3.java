class Solution {
    public int ways(String[] pizza, int k) {
        
        int[][] prefixSum = new int[pizza.length + 1][pizza[0].length() + 1];
        for (int i = 0; i < pizza.length; i++) {
            for (int j = 0; j < pizza[0].length(); j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j];
                if (pizza[i].charAt(j) == 'A') {
                    prefixSum[i + 1][j + 1]++;
                }
            }
        }
        int[][][] dp = new int[pizza.length][pizza[0].length()][k + 1];
        return dfs(prefixSum, dp, 0, 0, k);
    }
    private int dfs(int[][] prefixSum, int[][][] dp, int row, int col, int k) {
        int mod = 1000000007;
        if (k == 1) {
            return hasApple(prefixSum, row, col, prefixSum.length - 1, prefixSum[0].length - 1) ? 1 : 0;
        }
        if (dp[row][col][k] > 0) {
            return dp[row][col][k];
        }
        int count = 0;
        for (int i = row + 1; i < prefixSum.length - 1; i++) {
            if (hasApple(prefixSum, row, col, i - 1, prefixSum[0].length - 1)) {
                count = (count + dfs(prefixSum, dp, i, col, k - 1)) % mod;
            }
        }
        for (int i = col + 1; i < prefixSum[0].length - 1; i++) {
            if (hasApple(prefixSum, row, col, prefixSum.length - 1, i - 1)) {
                count = (count + dfs(prefixSum, dp, row, i, k - 1)) % mod;
            }
        }
        dp[row][col][k] = count;
        return count;
    }
}