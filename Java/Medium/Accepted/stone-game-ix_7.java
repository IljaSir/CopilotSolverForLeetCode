class Solution {
    public boolean stoneGameIX(int[] stones) {
        
        int[] dp = new int[3];
        for (int stone : stones) {
            dp[stone % 3]++;
        }
        if (dp[0] % 2 == 0) {
            return dp[1] != 0 && dp[2] != 0;
        } else {
            return Math.abs(dp[1] - dp[2]) >= 3;
        }
    }
}