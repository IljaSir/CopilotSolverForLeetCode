class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n + 1][initialEnergy + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= initialEnergy; j++) {
                if (j > energy[i]) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - energy[i]] + experience[i]);
                }
            }
            for (int j = 0; j <= initialEnergy; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i <= initialEnergy; i++) {
            if (dp[n][i] >= initialExperience) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}