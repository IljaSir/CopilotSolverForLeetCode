class Solution {
    public int minMoves(int target, int maxDoubles) {
        
        if (target == 1) {
            return 0;
        }
        int[] dp = new int[target + 1];
        for (int i = 2; i <= target; i++) {
            dp[i] = i - 1;
        }
        for (int i = 1; i <= maxDoubles; i++) {
            for (int j = target; j >= 1; j--) {
                for (int k = 2; j - k >= 0; k *= 2) {
                    dp[j] = Math.min(dp[j], dp[j - k] + k - 1);
                }
            }
        }
        return dp[target];
    }
}