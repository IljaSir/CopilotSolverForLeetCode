class Solution {
    public int[][] largestLocal(int[][] grid) {
        
        int[][] result = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                int max = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        max = Math.max(grid[k][l], max);
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}