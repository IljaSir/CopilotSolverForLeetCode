class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return res;
    }
}