class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        int[] ans = new int[m * n];
        int idx = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = matrix[i - 1][j - 1] ^ pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1];
                ans[idx++] = pre[i][j];
            }
        }
        Arrays.sort(ans);
        return ans[m * n - k];
    }
}