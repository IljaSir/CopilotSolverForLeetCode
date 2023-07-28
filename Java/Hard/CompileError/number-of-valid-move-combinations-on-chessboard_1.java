class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int n = pieces.length;
        int[] p = new int[n];
        for (int i = 0; i < n; ++i) {
            if (pieces[i].equals("rook")) {
                p[i] = 0;
            } else if (pieces[i].equals("bishop")) {
                p[i] = 1;
            } else {
                p[i] = 2;
            }
        }
        int[][] pos = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pos[i][0] = positions[i][0];
            pos[i][1] = positions[i][1];
        }
        int[][][] dp = new int[n][9][9];
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= 8; ++j) {
                for (int k = 1; k <= 8; ++k) {
                    if (i == 0) {
                        dp[i][j][k] = 1;
                    } else {
                        if (p[i] == 0) {
                            if (j == pos[i][0] || k == pos[i][1]) {
                                dp[i][j][k] = dp[i - 1][j][k];
                            } else {
                                dp[i][j][k] = dp[i - 1][j][k] + dp[i][j][k - 1];
                            }
                        } else if (p[i] == 1) {
                            if (j + k == pos[i][0] + pos[i][1] || j - k == pos[i][0] - pos[i][1]) {
                                dp[i][j][k] = dp[i - 1][j][k];
                            } else {
                                dp[i][j][k] = dp[i - 1][j][k] + dp[i][j][k - 1];
                            }
                        } else {
                            if (j + k == pos[i][0] + pos[i][1] || j - k == pos[i][0] - pos[i][1] || j == pos[i][0] || k == pos[i][1]) {
                                dp[i][j][k] = dp[i - 1][j][k];
    }
}