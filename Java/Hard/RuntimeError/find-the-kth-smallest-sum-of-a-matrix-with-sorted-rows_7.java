class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            int[] tmp = new int[n * m];
            int idx = 0;
            for (int j = 0; j < n; j++) {
                for (int t : dp) {
                    tmp[idx++] = t + mat[i][j];
                }
            }
            Arrays.sort(tmp);
            dp = Arrays.copyOfRange(tmp, 0, n);
        }
        return dp[k - 1];
    }
}