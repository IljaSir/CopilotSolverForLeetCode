class Solution {
    public int minCost(int n, int[] cuts) {
        
        int[] allCuts = new int[cuts.length + 2];
        allCuts[0] = 0;
        allCuts[allCuts.length - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            allCuts[i + 1] = cuts[i];
        }
        Arrays.sort(allCuts);
        int[][] dp = new int[allCuts.length][allCuts.length];
        for (int i = 2; i < allCuts.length; i++) {
            for (int j = 0; j + i < allCuts.length; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = j + 1; k < j + i; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k][j + i]);
                }
                dp[j][j + i] += allCuts[j + i] - allCuts[j];
            }
        }
        return dp[0][allCuts.length - 1];
    }
}