class Solution {
    public int[][] largestLocal(int[][] grid) {
        
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        for(int i = 0; i < maxLocal.length; i++) {
            for(int j = 0; j < maxLocal[i].length; j++) {
                maxLocal[i][j] = getMax(grid, i, j);
            }
        }
        return maxLocal;
    }
    
    public int getMax(int[][] grid, int x, int y) {
        int max = Integer.MIN_VALUE;
        for(int i = x; i < x + 3; i++) {
            for(int j = y; j < y + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}