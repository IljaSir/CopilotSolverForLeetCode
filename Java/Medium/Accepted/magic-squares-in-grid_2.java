class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                if (grid[i + 1][j + 1] != 5) continue;
                if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) continue;
                if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) continue;
                if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) continue;
                if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) continue;
                if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) continue;
                if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15) continue;
                boolean[] flags = new boolean[10];
                flags[0] = true;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (grid[i + k][j + l] < 1 || grid[i + k][j + l] > 9 || flags[grid[i + k][j + l]]) {
                            continue;
                        }
                        flags[grid[i + k][j + l]] = true;
                    }
                }
                boolean flag = true;
                for (int k = 1; k < 10; k++) {
                    if (!flags[k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }
        }
        return count;
    }
}