class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        int[][] dp = new int[n+1][initialEnergy+1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return minNumberOfHours(initialEnergy, initialExperience, energy, experience, 0, dp);
    }
    private int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience, int i, int[][] dp) {
        if (i == energy.length) {
            return 0;
        }
        if (dp[i][initialEnergy] != -1) {
            return dp[i][initialEnergy];
        }
        int ans = Integer.MAX_VALUE;
        if (initialEnergy > energy[i] && initialExperience > experience[i]) {
            ans = minNumberOfHours(initialEnergy - energy[i], initialExperience + experience[i], energy, experience, i+1, dp);
        }
        ans = Math.min(ans, 1 + minNumberOfHours(initialEnergy+1, initialExperience, energy, experience, i, dp));
        ans = Math.min(ans, 1 + minNumberOfHours(initialEnergy, initialExperience+1, energy, experience, i, dp));
        return dp[i][initialEnergy] = ans;
    }
}