class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[] max = new int[m];
        for (int i = 0; i < m; i++) {
            max[i] = grid[0][i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < m; j++) {
                maxVal = Math.max(maxVal, grid[i][j]);
                if (maxVal > max[j]) {
                    max[j] = maxVal;
                }
            }
            res += maxVal;
        }
        return res;
    }
}