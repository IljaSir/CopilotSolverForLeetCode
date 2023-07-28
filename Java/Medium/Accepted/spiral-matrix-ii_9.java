class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        int i = 0, j = 0, k = 0;
        int[] di = new int[]{0, 1, 0, -1};
        int[] dj = new int[]{1, 0, -1, 0};
        for (int num = 1; num <= n * n; num++) {
            matrix[i][j] = num;
            if (matrix[(i + di[k] + n) % n][(j + dj[k] + n) % n] != 0) {
                k = (k + 1) % 4;
            }
            i = (i + di[k] + n) % n;
            j = (j + dj[k] + n) % n;
        }
        return matrix;
    }
}