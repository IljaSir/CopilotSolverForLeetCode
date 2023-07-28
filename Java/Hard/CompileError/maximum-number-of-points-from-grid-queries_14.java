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
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int max = 0;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    int left = 1;
                    int right = Math.min(m - j + 1, n - k + 1);
                    while (left < right) {
                        int mid = left + (right - left + 1) / 2;
                        int sum = prefix[j + mid - 1][k + mid - 1] - prefix[j - 1][k + mid - 1] - prefix[j + mid - 1][k - 1] + prefix[j - 1][k - 1];
                        if (sum <= queries[i]) {
                            left = mid;
                        } else {
                            right = mid - 1;
         
        return ans;
    }
}