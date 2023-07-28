class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] top = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        top[i][j] = 1;
                    } else {
                        top[i][j] = top[i - 1][j] + 1;
                    }
                    if (j == 0) {
                        left[i][j] = 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int k = Math.min(left[i][j], top[i][j]);
                while (k > max) {
                    if (left[i - k + 1][j] >= k && top[i][j - k + 1] >= k) {
                        max = k;
                        break;
                    }
                    k--;
                }
            }
        }
        return max * max;
    }
}