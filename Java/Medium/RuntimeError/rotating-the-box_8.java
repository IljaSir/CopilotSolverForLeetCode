class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    dp[i][j] = 0;
                } else if (j == n - 1) {
                    dp[i][j] = box[i][j] == '#' ? 1 : 0;
                } else {
                    dp[i][j] = box[i][j] == '#' ? dp[i][j + 1] + 1 : dp[i][j + 1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > 0) {
                    for (int k = i; k >= 0; k--) {
                        if (box[k][j] == '*') {
                            box[k + 1][j] = '#';
                            box[k][j] = '.';
                            break;
                        }
                        if (k == 0) {
                            box[k][j] = '.';
                            box[k + dp[i][j] - 1][j] = '#';
                        }
                    }
                }
            }
        }
        char[][] ans = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = box[i][j];
            }
        }
        return ans;
    }
}