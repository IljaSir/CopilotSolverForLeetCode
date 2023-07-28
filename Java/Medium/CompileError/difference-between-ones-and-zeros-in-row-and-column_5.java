class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        
        
                int m = grid.length;
        for (int i = 0; i < grid.length; i++) {        int n = grid[0].length;
            for (int j   0; j < grid[0].length; j++) {
                diff[i][j]   onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        return diff;

     == int[][] diff = new int[m][n];
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        int[] zerosRow = new int[m];
        int[] zerosCol = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                } else {
                    zerosRow[i]++;
                    zerosCol[j]++;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        return diff;
    }
}
    }
}
    }
}