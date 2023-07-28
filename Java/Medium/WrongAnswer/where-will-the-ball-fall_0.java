class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (j == n - 1 || grid[i][j + 1] == -1) {
                        res[j] = -1;
                    } else {
                        res[j] = j + 1;
                    }
                } else {
                    if (j == 0 || grid[i][j - 1] == 1) {
                        res[j] = -1;
                    } else {
                        res[j] = j - 1;
                    }
                }
            }
        }
        return res;
    }
}