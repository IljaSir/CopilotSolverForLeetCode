class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = grid[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int max = 0;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    int maxj = 0, maxk = 0;
                    int lo = 1, hi = Math.min(m - j + 1, n - k + 1);
                    while (lo <= hi) {
                        int mid = lo + (hi - lo) / 2;
                        int sum = prefix[j + mid - 1][k + mid - 1] - prefix[j - 1][k + mid - 1] - prefix[j + mid - 1][k - 1] + prefix[j - 1][k - 1];
                        if (sum <= q * mid * mid) {
                            maxj = j + mid - 1;
                            maxk = k + mid - 1;
                            lo = mid + 1;
                        } else {
                            hi = mid - 1;
                        }
                    }
                    max = Math.max(max, prefix[maxj][maxk] - prefix[maxj][k - 1] - prefix[j - 1][maxk] + prefix[j - 1][k - 1]);
                }
            }
            res[i] = max;
        }
        return res;
    }
}