class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n + 1][initialEnergy + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][initialEnergy] = initialExperience;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= initialEnergy; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i + 1][Math.min(initialEnergy, j + energy[i])] = Math.max(dp[i + 1][Math.min(initialEnergy, j + energy[i])], dp[i][j] + experience[i]);
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= initialEnergy; i++) {
            if (dp[n][i] != Integer.MAX_VALUE) {
                ans = Math.min(ans, i);
            }
        }
        return ans;
    }
}