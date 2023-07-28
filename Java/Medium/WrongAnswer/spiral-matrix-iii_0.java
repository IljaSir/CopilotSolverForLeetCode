class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] res = new int[rows * cols][2];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;
        int r = rStart;
        int c = cStart;
        int count = 0;
        while (count < rows * cols) {
            res[count++] = new int[]{r, c};
            int cr = r + dr[dir];
            int cc = c + dc[dir];
            if (0 <= cr && cr < rows && 0 <= cc && cc < cols) {
                r = cr;
                c = cc;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        return res;
    }
}