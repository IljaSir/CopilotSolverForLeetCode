class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int m = board.size(), n = board.get(0).length();
        int[][] dp = new int[m][n];
        int[][] paths = new int[m][n];
        int[] res = new int[2];
        int mod = (int)1e9 + 7;
        dp[m - 1][n - 1] = 0;
        paths[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') continue;
                if (i == m - 1 && j == n - 1) continue;
                int max = Math.max(Math.max(i + 1 < m ? dp[i + 1][j] : 0, j + 1 < n ? dp[i][j + 1] : 0), i + 1 < m && j + 1 < n ? dp[i + 1][j + 1] : 0);
                dp[i][j] = max;
                if (i + 1 < m && dp[i + 1][j] == max) paths[i][j] = (paths[i][j] + paths[i + 1][j]) % mod;
                if (j + 1 < n && dp[i][j + 1] == max) paths[i][j] = (paths[i][j] + paths[i][j + 1]) % mod;
                if (i + 1 < m && j + 1 < n && dp[i + 1][j + 1] == max) paths[i][j] = (paths[i][j] + paths[i + 1][j + 1]) % mod;
                if (Character.isDigit(board.get(i).charAt(j))) dp[i][j] += board.get(i).charAt(j) - '0';
            }
        }
        res[0] = dp[0][0];
        res[1] = paths[0][0];
        return res;
    }
}