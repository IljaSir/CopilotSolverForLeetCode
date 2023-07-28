class Solution {
    public int minimumNumbers(int num, int k) {
        
        if (num == 0) {
            return 0;
        }
        int[] dp = new int[num + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= num; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (int j = 1; j <= 9; j++) {
                    if (i + j * k <= num) {
                        dp[i + j * k] = Math.min(dp[i + j * k], dp[i] + j);
                    }
                }
            }
        }
        return dp[num] == Integer.MAX_VALUE ? -1 : dp[num];
    }
}