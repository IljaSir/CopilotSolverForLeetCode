class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n][initialEnergy + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][initialEnergy] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= initialEnergy; j++) {
                if (dp[i][j] != Integer.MAX_VALUE) {
                    if (j > experience[i]) {
                        dp[i][j - experience[i]] = Math.min(dp[i][j - experience[i]], dp[i][j]);
                    }
                    if (j > energy[i]) {
                        dp[i][j - energy[i]] = Math.min(dp[i][j - energy[i]], dp[i][j] + 1);
                    }
                    if (i + 1 < n) {
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= initialEnergy; j++) {
            if (dp[n - 1][j] != Integer.MAX_VALUE) {
                ans = Math.min(ans, dp[n - 1][j]);
            }
        }
        return ans;
    }
}