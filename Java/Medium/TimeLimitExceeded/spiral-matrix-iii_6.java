class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] res = new int[rows * cols][2];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0, index = 0;
        res[index++] = new int[]{rStart, cStart};
        for (int step = 1; index < rows * cols; step++) {
            for (int k = 0; k < 2; k++) {
                for (int m = 0; m < step; m++) {
                    i += dir[k][0];
                    j += dir[k][1];
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        res[index++] = new int[]{i, j};
                    }
                }
            }
        }
        return res;
    }
}