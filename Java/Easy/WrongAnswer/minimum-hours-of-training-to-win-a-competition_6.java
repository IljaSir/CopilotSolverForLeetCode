class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n+1][initialEnergy+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][initialEnergy] = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 1; j <= initialEnergy; j++) {
                if (dp[i+1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j]);
                }
                if (j > energy[i] && dp[i+1][j-energy[i]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j-energy[i]] + experience[i]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= initialEnergy; i++) {
            ans = Math.min(ans, dp[0][i]);
        }
        return ans - initialExperience;
    }
}