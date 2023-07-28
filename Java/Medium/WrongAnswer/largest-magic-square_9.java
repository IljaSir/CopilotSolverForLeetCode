class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] rsum = new int[m + 1][n + 1], csum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                rsum[i][j] = rsum[i][j - 1] + grid[i - 1][j - 1];
                csum[i][j] = csum[i - 1][j] + grid[i - 1][j - 1];
            }
        }
        int ans = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = Math.min(m - i, n - j) + 1; k > ans; k--) {
                    if (check(rsum, csum, i, j, k)) {
                        ans = k;
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean check(int[][] rsum, int[][] csum, int i, int j, int k) {
        int sum = rsum[i][j + k - 1] - rsum[i][j - 1];
        for (int p = i; p < i + k; p++) {
            if (rsum[p][j + k - 1] - rsum[p][j - 1] != sum) {
                return false;
            }
        }
        for (int p = j; p < j + k; p++) {
            if (csum[i + k - 1][p] - csum[i - 1][p] != sum) {
                return false;
            }
        }
        if (csum[i + k - 1][j + k - 1] - csum[i - 1][j - 1] != sum) {
            return false;
        }
        if (csum[i + k - 1][j - 1] - csum[i - 1][j + k - 1] != sum) {
            return false;
        }
        return true;
    }
}