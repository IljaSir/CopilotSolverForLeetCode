class Solution {
    public int surfaceArea(int[][] grid) {
        
        int n = grid.length;
        int totalArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                int left = j == 0 ? 0 : grid[i][j - 1];
                int right = j == n - 1 ? 0 : grid[i][j + 1];
                int top = i == 0 ? 0 : grid[i - 1][j];
                int bottom = i == n - 1 ? 0 : grid[i + 1][j];
                int area = height * 4 + 2;
                area = area - Math.min(height, left) * 2;
                area = area - Math.min(height, right) * 2;
                area = area - Math.min(height, top) * 2;
                area = area - Math.min(height, bottom) * 2;
                totalArea += area;
            }
        }
        return totalArea;
    }
}