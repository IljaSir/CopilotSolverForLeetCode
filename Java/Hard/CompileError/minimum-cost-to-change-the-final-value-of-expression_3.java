class Solution {
    public int minOperationsToFlip(String expression) {
        
        int n = expression.length();
        int[][] dp = new int[n][n];
        int[][] dp2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                dp2[i][j] = Integer.MAX_VALUE;
            }
        } = ans;
    }
}