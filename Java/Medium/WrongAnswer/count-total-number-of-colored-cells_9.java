class Solution {
    public long coloredCells(int n) {
        
        if (n == 1) {
            return 1;
        }
        long ans = 0;
        int i = 0, j = 0;
        int[][] grid = new int[2 * n][2 * n];
        grid[i][j] = 1;
        ans++;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < 4; l++) {
                for (int m = 0; m < k; m++) {
                    i += (l == 0) ? 1 : (l == 2) ? -1 : 0;
                    j += (l == 1) ? 1 : (l == 3) ? -1 : 0;
                    if (grid[i][j] == 0) {
                        ans++;
                        grid[i][j] = 1;
                    }
                }
            }
        }
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < n; l++) {
                i += (k == 0) ? 1 : (k == 2) ? -1 : 0;
                j += (k == 1) ? 1 : (k == 3) ? -1 : 0;
                if (grid[i][j] == 0) {
                    ans++;
                    grid[i][j] = 1;
                }
            }
        }
        return ans;
    }
}