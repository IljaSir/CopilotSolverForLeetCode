class Solution {
    public int[][] largestLocal(int[][] grid) {
        
        int[][] maxLocal = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                int max = 0;
                for (int ii = i; ii < i + 3; ii++) {
                    for (int jj = j; jj < j + 3; jj++) {
                        max = Math.max(max, grid[ii][jj]);
                    }
                }
                maxLocal[i][j] = max;
            }
        }
        return maxLocal;
    }
}