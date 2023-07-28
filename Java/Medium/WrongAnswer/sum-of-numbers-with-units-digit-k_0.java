class Solution {
    public int minimumNumbers(int num, int k) {
        
        int[] dp = new int[num + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i - j >= 0 && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        return dp[num] == Integer.MAX_VALUE ? -1 : dp[num];
    }
}