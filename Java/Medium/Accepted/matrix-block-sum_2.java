class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int x = Math.max(0, i - k); x <= Math.min(m - 1, i + k); x++) {
                    for (int y = Math.max(0, j - k); y <= Math.min(n - 1, j + k); y++) {
                        sum += mat[x][y];
                    }
                }
                ans[i][j] = sum;
            }
        }
        return ans;
    }
}