class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n + 1][initialEnergy + 1];
        for (int i = 0; i <= initialEnergy; i++) {
            dp[n][i] = Integer.MAX_VALUE / 2;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= initialEnergy; j++) {
                if (j < energy[i]) {
                    dp[i][j] = Integer.MAX_VALUE / 2;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j - energy[i]] + experience[i], dp[i + 1][j]);
                }
            }
        }
        int res = 0;
        for (int i = initialExperience; i <= initialEnergy; i++) {
            res = Math.max(res, i - dp[0][i]);
        }
        return res;
    }
}