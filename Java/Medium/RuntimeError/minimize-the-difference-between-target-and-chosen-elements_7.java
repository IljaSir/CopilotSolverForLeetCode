class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int[] dp = new int[71];
        Arrays.fill(dp, 1000);
        dp[0] = 0;
        for (int[] row : mat) {
            int[] next = new int[71];
            Arrays.fill(next, 1000);
            for (int i = 0; i <= 70; i++) {
                for (int j : row) {
                    next[Math.abs(i - j)] = Math.min(next[Math.abs(i - j)], dp[i]);
                    next[i + j] = Math.min(next[i + j], dp[i] + 1);
                }
            }
            dp = next;
        }
        return dp[target];
    }
}