class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] result = new int[rows * cols][];
        int r = rStart;
        int c = cStart;
        int direction = 0;
        int step = 0;
        int i = 0;
        while (i < rows * cols) {
            result[i++] = new int[]{r, c};
            if (direction == 0) {
                c++;
                if (c == cols || c == cols - 1) {
                    direction = 1;
                }
            } else if (direction == 1) {
                r++;
                if (r == rows || r == rows - 1) {
                    direction = 2;
                }
            } else if (direction == 2) {
                c--;
                if (c == 0 || c == 1) {
                    direction = 3;
                }
            } else if (direction == 3) {
                r--;
                if (r == 0 || r == 1) {
                    direction = 0;
                }
            }
            if (r >= rows || r < 0 || c >= cols || c < 0) {
                if (direction == 0) {
                    c--;
                    r++;
                } else if (direction == 1) {
                    r--;
                    c--;
                } else if (direction == 2) {
                    c++;
                    r--;
                } else if (direction == 3) {
                    r++;
                    c++;
                }
            }
        }
        return result;
    }
}