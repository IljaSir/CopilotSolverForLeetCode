class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int[][] ans = new int[mat.length][mat[0].length];
        int[][] sum = new int[mat.length + 1][mat[0].length + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + mat[i][j];
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int r1 = Math.max(0, i - k), c1 = Math.max(0, j - k), r2 = Math.min(mat.length, i + k + 1), c2 = Math.min(mat[0].length, j + k + 1);
                ans[i][j] = sum[r2][c2] - sum[r1][c2] - sum[r2][c1] + sum[r1][c1];
            }
        }
        return ans;
    }
}