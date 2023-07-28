class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = mat[0][i];
        }
        for (int i = 1; i < m; i++) {
            Arrays.fill(temp, Integer.MAX_VALUE);
            for (int j =];
    }
}