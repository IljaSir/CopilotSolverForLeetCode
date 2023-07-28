class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        int[][] dp = new int[n][n];
        int[][] count = new int[n][n];
        dp[n - 1][n - 1] = 0;
        count[n - 1][n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (board.get(i).charAt(n - 1) == 'X') {
                break;
            }
            dp[i][n - 1] = dp[i + 1][n - 1] + board.get(i).charAt(n - 1) - '0';
            count[i][n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (board.get(n - 1).charAt(i) == 'X') {
                break;
            }
            dp[n - 1][i] = dp[n - 1][i + 1] + board.get(n - 1).charAt(i) - '0';
            count[n - 1][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') {
                    continue;
                }
                int max = Math.max(dp[i + 1][j], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
                if (max == dp[i + 1][j]) {
                    count[i][j] += count[i + 1][j];
                }
                if (max == dp[i][j + 1]) {
                    count[i][j] += count[i][j + 1];
                }
                if (max == dp[i + 1][j + 1]) {
                    count[i][j] += count[i + 1][j + 1];
                }
                dp[i][j] = max + board.get(i).charAt(j) - '0';
                count[i][j] %= 1000000007;
            }
        }
        return new int[]{dp[0][0], count[0][0]};
    }
}