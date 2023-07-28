class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int n = grid.length;
        int[] topBottom = new int[n];
        int[] leftRight = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                topBottom[i] = Math.max(topBottom[i], grid[i][j]);
                leftRight[j] = Math.max(leftRight[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(topBottom[i], leftRight[j]) - grid[i][j];
            }
        }
        return res;
    }
}