class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                }
            }
        }
        return res;
    }
}