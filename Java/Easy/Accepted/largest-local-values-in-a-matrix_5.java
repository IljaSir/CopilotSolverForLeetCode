class Solution {
    public int[][] largestLocal(int[][] grid) {
        
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= i + 2; k++) {
                    for (int l = j; l <= j + 2; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }
                maxLocal[i][j] = max;
            }
        }
        return maxLocal;
    }
}