class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int n = pieces.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = pieces[i].equals("rook") ? 0 : pieces[i].equals("bishop") ? 1 : 2;
        }
        int[][][] dp = new int[n][8][8];
        dp[0][positions[0][0] - 1][positions[0][1] - 1] = 1;
        for (int i = 1; i < n; i++) {
            int x = positions[i][0] - 1, y = positions[i][1] - 1;
            if (p[i] == 0) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        if (j == x || k == y) {
                            dp[i][j][k] = dp[i - 1][j][k];
                        }
                    }
                }
            } else if (p[i] == 1) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        if (Math.abs(j - x) == Math.abs(k - y)) {
                            dp[i][j][k] = dp[i - 1][j][k];
                        }
                    }
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        if (j == x || k == y || Math.abs(j - x) == Math.abs(k - y)) {
                            dp[i][j][k] = dp[i - 1][j][k];
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                res += dp[n - 1][i][j];
            }
        }
        return res;
    }
}