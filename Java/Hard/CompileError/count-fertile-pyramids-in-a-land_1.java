class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] leftUp = new int[m][n];
        int[][] rightUp = new int[m][n];
        int[][] leftDown = new int[m][n];
        int[][] rightDown = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (j == 0) {
                    left[i][j] = 1;
                } else {
                    left[i][j] = left[i][j - 1] + 1;
                }
                if (i == 0) {
                    up[i][j] = 1;
                } else {
                    up[i][j] = up[i - 1][j] + 1;
                }
                if (i == 0 || j == 0) {
                    leftUp[i][j] = 1;
                } else {
                    leftUp[i][j] = leftUp[i - 1][j - 1] + 1;
                }
                if (i == 0 || j == n - 1) {
                    rightUp[i][j] = 1;
                } else {
                    rightUp[i][j] = rightUp[i - 1][j + 1] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (j == n - 1) {
                    right[i][j] = 1;
                } else {
                    right[i][j] = right[i][j + 1] + 1;
                }
                if (i == m - 1) {
                    down[i][j] = 1;
                } else {
                    down
    }
}