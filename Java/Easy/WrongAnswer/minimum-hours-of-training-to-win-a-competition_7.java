class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n+1][initialEnergy+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][initialEnergy] = initialExperience;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= initialEnergy; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int e = j - energy[i];
                int exp = dp[i][j] + experience[i];
                if (e > 0 && exp > 0) {
                    dp[i+1][e] = Math.min(dp[i+1][e], exp);
                }
            }
            for (int j = 1; j <= initialEnergy; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i+1][j-1]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= initialEnergy; i++) {
            if (dp[n][i] != Integer.MAX_VALUE) {
                ans = i;
                break;
            }
        }
        return initialEnergy - ans;
    }
}