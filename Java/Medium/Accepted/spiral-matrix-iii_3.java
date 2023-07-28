class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] result = new int[rows * cols][2];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        result[index++] = new int[]{rStart, cStart};
        int step = 1;
        int dir = 0;
        while (index < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {
                    rStart += dirs[dir][0];
                    cStart += dirs[dir][1];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = new int[]{rStart, cStart};
                    }
                }
                dir = (dir + 1) % 4;
            }
            step++;
        }
        return result;
    }
}