class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int x, int y) {
        int[] nums = new int[16];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nums[grid[x + i][y + j]]++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (nums[i] != 1) {
                return false;
            }
        }
        int sum = grid[x][y] + grid[x][y + 1] + grid[x][y + 2];
        for (int i = 0; i < 3; i++) {
            if (grid[x + i][y] + grid[x + i][y + 1] + grid[x + i][y + 2] != sum) {
                return false;
            }
            if (grid[x][y + i] + grid[x + 1][y + i] + grid[x + 2][y + i] != sum) {
                return false;
            }
        }
        if (grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] != sum) {
            return false;
        }
        if (grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2] != sum) {
            return false;
        }
        return true;
    }
}