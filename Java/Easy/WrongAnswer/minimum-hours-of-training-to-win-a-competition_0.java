class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n + 1][initialEnergy + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][initialEnergy] = initialExperience;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= initialEnergy; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int exp = dp[i][j];
                if (j - energy[i] > 0 && exp - experience[i] > 0) {
                    dp[i + 1][j - energy[i]] = Math.max(dp[i + 1][j - energy[i]], exp - experience[i]);
                }
                dp[i + 1][j] = Math.max(dp[i + 1][j], exp);
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= initialEnergy; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                ans = Math.max(ans, j + i);
            }
        }
        return ans;
    }
}