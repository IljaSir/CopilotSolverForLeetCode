class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (floor.charAt(i) == '1' ? 1 : 0);
        }
        int[][] dp = new int[n + 1][numCarpets + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= numCarpets; j++) {
                int sum = prefix[i + 1] - prefix[i + 1 - carpetLen];
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + carpetLen - sum);
                if (j < numCarpets) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + sum);
                }
            }
        }
        return dp[n][numCarpets];
    }
}