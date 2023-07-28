class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] res = new int[rows * cols][2];
        int index = 0;
        int x = rStart;
        int y = cStart;
        int step = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while (index < rows * cols) {
            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                res[index++] = new int[]{x, y};
            }
            if (directionIndex == 0 || directionIndex == 2) {
                step++;
            }
            x += directions[directionIndex][0];
            y += directions[directionIndex][1];
            directionIndex = (directionIndex + 1) % 4;
            for (int i = 0; i < step; i++) {
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    res[index++] = new int[]{x, y};
                }
                x += directions[directionIndex][0];
                y += directions[directionIndex][1];
            }
            directionIndex = (directionIndex + 1) % 4;
        }
        return res;
    }
}