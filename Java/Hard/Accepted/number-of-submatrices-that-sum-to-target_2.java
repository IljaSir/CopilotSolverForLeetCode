class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = i; k <= n; k++) {
                    for (int l = j; l <= m; l++) {
                        if (sum[k][l] - sum[i - 1][l] - sum[k][j - 1] + sum[i - 1][j - 1] == target) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}