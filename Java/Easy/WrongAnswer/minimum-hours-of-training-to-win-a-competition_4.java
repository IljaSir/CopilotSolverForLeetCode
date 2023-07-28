class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n + 1][initialEnergy + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][initialEnergy] = initialExperience;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= initialEnergy; j++) {
                if (dp[i][j] != Integer.MAX_VALUE) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                    if (j > energy[i]) {
                        dp[i + 1][j - energy[i]] = Math.min(dp[i + 1][j - energy[i]], dp[i][j] + experience[i]);
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j <= initialEnergy; j++) {
            if (dp[n][j] != Integer.MAX_VALUE) {
                ans = j;
                break;
            }
        }
        return initialEnergy - ans;
    }
}