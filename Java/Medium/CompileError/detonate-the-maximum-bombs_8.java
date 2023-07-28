class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isOverlap(bombs[i], bombs[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}