class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int n = mat.length, m = mat[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[m * n + 1];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            for (int j = 0; j < m; j++) {
                for (int t = 0; t < m * n; t++) {
                    if (tmp[t] != Integer.MAX_VALUE) {
                        tmp[t + mat[i][j]] = Math.min(tmp[t + mat[i][j]], tmp[t]);
                    }
                }
            }
            Arrays.sort(tmp);
            for (int j = 0; j < m; j++) {
                dp[j] = tmp[j];
            }
        }
        return dp[k - 1];
    }
}