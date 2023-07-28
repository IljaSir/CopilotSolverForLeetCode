class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        int[][] dp = new int[n][n];
        int[][] count = new int[n][n];
        count[n - 1][n - 1] = 1;
        int mod = 1000000007;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') {
                    continue;
                }
                if (i == n - 1 && j == n - 1) {
                    continue;
                }
                int max = 0;
                if (i + 1 < n) {
                    max = Math.max(max, dp[i + 1][j]);
                }
                if (j + 1 < n) {
                    max = Math.max(max, dp[i][j + 1]);
                }
                if (i + 1 < n && j + 1 < n) {
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
                dp[i][j] = max + (board.get(i).charAt(j) - '0');
                if (i + 1 < n && dp[i + 1][j] == max) {
                    count[i][j] = (count[i][j] + count[i + 1][j]) % mod;
                }
                if (j + 1 < n && dp[i][j + 1] == max) {
                    count[i][j] = (count[i][j] + count[i][j + 1]) % mod;
                }
                if (i + 1 < n && j + 1 < n && dp[i + 1][j + 1] == max) {
                    count[i][j] = (count[i][j] + count[i + 1][j + 1]) % mod;
                }
            }
        }
        return new int[]{dp[0][0], count[0][0]};
    }
}