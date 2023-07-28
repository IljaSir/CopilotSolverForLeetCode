class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        int[][] dp = new int[n][n];
        int[][] paths = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                paths[i][j] = 0;
            }
        }
        paths[n - 1][n - 1] = 1;
        dp[n - 1][n - 1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') {
                    continue;
                }
                int max = 0;
                int ways = 0;
                for (int[] dir : new int[][]{{0, 1}, {1, 0}, {1, 1}}) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= n) {
                        continue;
                    }
                    if (dp[ni][nj] == Integer.MIN_VALUE) {
                        continue;
                    }
                    if (dp[ni][nj] > max) {
                        max = dp[ni][nj];
                        ways = paths[ni][nj];
                    } else if (dp[ni][nj] == max) {
                        ways = (ways + paths[ni][nj]) % 1000000007;
                    }
                }
                if (board.get(i).charAt(j) != 'E') {
                    max += board.get(i).charAt(j) - '0';
                }
                dp[i][j] = max;
                paths[i][j] = ways;
            }
        }
        return new int[]{dp[0][0], paths[0][0]};
    }
}