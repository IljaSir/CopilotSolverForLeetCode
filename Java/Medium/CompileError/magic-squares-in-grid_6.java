class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int r = grid.length;
        if (r < 3) {
            return 0;
        }
        int c = grid[0].length;
        if (c < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) {
                    continue;
                }
                if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) {
                    continue;
                }
                if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) {
                    continue;
                }
                if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) {
                    continue;
                }
                if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) {
                    continue;
                }
                if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15) {
                    continue;
                }
                int[] temp = new int[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (grid[k][l] < 1 || grid[k][l] > 9) {
                            continue;
                        }
                        temp[grid[k][l]]++;
                    }
                }
                boolean flag = true;
                for (int k = 1; k < 10; k++) {
                    if (temp[k] != 1) {
                        flag = false;
                        break;
                    }
                }
                if (
    }
}