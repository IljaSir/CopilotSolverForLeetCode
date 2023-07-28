class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int left = 1;
        int right = Math.min(m, n);
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, sum, threshold)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    private boolean check(int k, int[][] sum, int threshold) {
        for (int i = k; i < sum.length; i++) {
            for (int j = k; j < sum[0].length; j++) {
                if (sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}