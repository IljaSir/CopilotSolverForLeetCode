class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        int[][] dp = new int[n + 1][n + 1];
        int[][] cnt = new int[n + 1][n + 1];
        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};
        int mod = (int)1e9 + 7;
        dp[n - 1][n - 1] = 0;
        cnt[n - 1][n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') continue;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && cnt[x][y] > 0) {
                        if (dp[x][y] + board.get(i).charAt(j) - '0' > dp[i][j]) {
                            dp[i][j] = dp[x][y] + board.get(i).charAt(j) - '0';
                            cnt[i][j] = cnt[x][y];
                        } else if (dp[x][y] + board.get(i).charAt(j) - '0' == dp[i][j]) {
                            cnt[i][j] += cnt[x][y];
                            cnt[i][j] %= mod;
                        }
                    }
                }
            }
        }
        int[] res = new int[2];
        res[0] = dp[0][0];
        res[1] = cnt[0][0];
        if (board.get(0).charAt(0) != 'S') {
            res[0] += board.get(0).charAt(0) - '0';
        }
        return res;
    }
}