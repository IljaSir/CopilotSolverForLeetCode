class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = grid[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
            }
        }
        int[] ans = new int[3];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 1; i + l < m && j + l < n && i - l >= 0 && j - l >= 0; l++) {
                    int cur = sum[i + l][j + l] - sum[i - l - 1][j + l] - sum[i + l][j - l - 1] + sum[i - l - 1][j - l - 1];
                    if (k < 3) {
                        ans[k++] = cur;
                    } else {
                        int min = ans[0];
                        int index = 0;
                        for (int p = 1; p < 3; p++) {
                            if (ans[p] < min) {
                                min = ans[p];
                                index = p;
                            }
                        }
                        if (min < cur) {
                            ans[index] = cur;
                        }
                    }
                }
            }
        }
        Arrays.sort(ans);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = ans[k - i - 1];
        }
        return res;
    }
}