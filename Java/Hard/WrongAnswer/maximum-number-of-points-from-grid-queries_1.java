class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int q = queries[k];
            int max = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i - 1][j - 1] <= q) continue;
                    int l = 0;
                    int r = Math.min(i, j);
                    while (l < r) {
                        int mid = (l + r + 1) / 2;
                        int sum = prefix[i][j] - prefix[i - mid][j] - prefix[i][j - mid] + prefix[i - mid][j - mid];
                        if (sum <= q * mid * mid) {
                            r = mid - 1;
                        } else {
                            l = mid;
                        }
                    }
                    max = Math.max(max, l);
                }
            }
            ans[k] = max;
        }
        return ans;
    }
}