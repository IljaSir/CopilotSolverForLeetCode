class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        int[][] dp = new int[n][n];
        int[][] paths = new int[n][n];
        paths[n-1][n-1] = 1;
        int mod = 1000000007;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') continue;
                int val = 0;
                if (board.get(i).charAt(j) >= '1' && board.get(i).charAt(j) <= '9') {
                    val = board.get(i).charAt(j) - '0';
                }
                if (i == n - 1 && j == n - 1) {
                    dp[i][j] = val;
                    paths[i][j] = 1;
                    continue;
                }
                int[] dir = new int[]{-1, 0, -1};
                int[] dir2 = new int[]{0, -1, -1};
                for (int k = 0; k < 3; k++) {
                    int x = i + dir[k];
                    int y = j + dir2[k];
                    if (x >= 0 && y >= 0 && dp[x][y] + val > dp[i][j]) {
                        dp[i][j] = dp[x][y] + val;
                        paths[i][j] = paths[x][y];
                    } else if (x >= 0 && y >= 0 && dp[x][y] + val == dp[i][j]) {
                        paths[i][j] = (paths[i][j] + paths[x][y]) % mod;
                    }
                }
            }
        }
        return new int[]{dp[0][0], paths[0][0]};
    }
}