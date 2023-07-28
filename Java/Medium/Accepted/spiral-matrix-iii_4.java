class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] result = new int[rows * cols][2];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int steps = 0;
        int i = 0;
        result[i][0] = rStart;
        result[i][1] = cStart;
        i++;
        while (i < rows * cols) {
            if (dir == 0 || dir == 2) {
                steps++;
            }
            for (int j = 0; j < steps; j++) {
                rStart += directions[dir][0];
                cStart += directions[dir][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[i][0] = rStart;
                    result[i][1] = cStart;
                    i++;
                }
            }
            dir = (dir + 1) % 4;
        }
        return result;
    }
}