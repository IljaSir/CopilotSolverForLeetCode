class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count += countPyramid(i, j, grid);
                    count += countInversePyramid(i, j, grid);
                }
            }
        }
        return count;
    }

    private int countPyramid(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int h = 1; i + h < m && j - h >= 0 && j + h < n; h++) {
            if (grid[i + h][j - h] == 1 && grid[i + h][j + h] == 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private int countInversePyramid(int i, int j, int[][] grid) {
        int count = 0;
        for (int h = 1; i - h >= 0 && j - h >= 0 && j + h < grid[0].length; h++) {
            if (grid[i - h][j - h] == 1 && grid[i - h][j + h] == 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}