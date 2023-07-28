class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        int[][] dp = new int[n][n];
        int[][] path = new int[n][n];
        int mod = 1000000007;
        dp[n - 1][n - 1] = 0;
        path[n - 1][n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') {
                    dp[i][j] = -1;
                } else if (i == n - 1 && j == n - 1) {
                    continue;
                } else {
                    int max = -1;
                    int p = 0;
                    if (i < n - 1) {
                        max = dp[i + 1][j];
                        p = path[i + 1][j];
                    }
                    if (j < n - 1 && dp[i][j + 1] > max) {
                        max = dp[i][j + 1];
                        p = path[i][j + 1];
                    }
                    if (i < n - 1 && j < n - 1 && dp[i + 1][j + 1] > max) {
                        max = dp[i + 1][j + 1];
                        p = path[i + 1][j + 1];
                    }
                    if (max == -1) {
                        dp[i][j] = -1;
                    } else {
                        dp[i][j] = max + (board.get(i).charAt(j) == 'E' ? 0 : board.get(i).charAt(j) - '0');
                        path[i][j] = p;
                    }
                }
            }
        }
        return new int[]{Math.max(dp[0][0], 0), dp[0][0] == -1 ? 0 : path[0][0] % mod};
    }
}