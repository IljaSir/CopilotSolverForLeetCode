class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] res = new int[rows*cols][2];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = rStart, c = cStart, di = 0;
        for (int i = 0; i < rows*cols; i++) {
            res[i] = new int[]{r, c};
            r += dr[di];
            c += dc[di];
            if (r >= rows || r < 0 || c >= cols || c < 0 || (r == rStart && c == cStart)) {
                r -= dr[di];
                c -= dc[di];
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return res;
    }
}