class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] result = new int[rows * cols][2];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int step = 0;
        int direction = 0;
        while (index < rows * cols) {
            if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols) {
                result[index][0] = rStart;
                result[index][1] = cStart;
                index++;
            }
            if (direction == 0 || direction == 2) {
                step++;
            }
            rStart += directions[direction][0];
            cStart += directions[direction][1];
            direction = (direction + 1) % 4;
            for (int i = 0; i < step; i++) {
                if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols) {
                    result[index][0] = rStart;
                    result[index][1] = cStart;
                    index++;
                }
                rStart += directions[direction][0];
                cStart += directions[direction][1];
            }
        }
        return result;
    }
}