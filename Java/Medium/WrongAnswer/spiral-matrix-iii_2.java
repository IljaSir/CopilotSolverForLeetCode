class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] res = new int[rows * cols][2];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = rStart, c = cStart, di = 0;
        for (int i = 0; i < rows * cols; i++) {
            res[i] = new int[]{r, c};
            r += dirs[di][0];
            c += dirs[di][1];
            if (r < 0 || c < 0 || r >= rows || c >= cols) {
                r -= dirs[di][0];
                c -= dirs[di][1];
                di = (di + 1) % 4;
                r += dirs[di][0];
                c += dirs[di][1];
            }
        }
        return res;
    }
}