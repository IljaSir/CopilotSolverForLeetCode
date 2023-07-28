class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int[][] grid = new int[101][101];
        for (int i = 0; i < circles.length; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            for (int j = x - r; j <= x + r; j++) {
                for (int k = y - r; k <= y + r; k++) {
                    if (j >= 0 && j <= 100 && k >= 0 && k <= 100 && (x - j) * (x - j) + (y - k) * (y - k) <= r * r) {
                        grid[j][k] = 1;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}