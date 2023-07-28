class Solution {
    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        int[] cuts2 = new int[cuts.length + 2];
        cuts2[0] = 0;
        cuts2[cuts.length + 1] = n;
        for(int i = 0; i < cuts.length; i++) {
            cuts2[i + 1] = cuts[i];
        }
        int[][] dp = new int[cuts2.length][cuts2.length];
        for(int i = cuts2.length - 3; i >= 0; i--) {
            for(int j = i + 2; j < cuts2.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + cuts2[j] - cuts2[i]);
                }
            }
        }
        return dp[0][cuts2.length - 1];
    }
}