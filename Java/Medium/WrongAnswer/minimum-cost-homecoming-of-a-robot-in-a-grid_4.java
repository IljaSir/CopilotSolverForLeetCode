class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        
        int m = rowCosts.length;
        int n = colCosts.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[startPos[0]][startPos[1]] = 0;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (k < 2) {
                            dp[x][y] = Math.min(dp[x][y], dp[i][j] + rowCosts[x]);
                        } else {
                            dp[x][y] = Math.min(dp[x][y], dp[i][j] + colCosts[y]);
                        }
                    }
                }
            }
        }
        return dp[homePos[0]][homePos[1]];
    }
}