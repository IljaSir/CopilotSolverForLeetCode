class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int[] dp = new int[6000];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < 6000; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                int[] digits = new int[4];
                int t = i;
                for (int j = 3; j >= 0; j--) {
                    digits[j] = t % 10;
                    t /= 10;
                }
                for (int j = 0; j < 4; j++) {
                    int newTime = i + 10 * (digits[j] - startAt);
                    if (newTime < 6000) {
                        dp[newTime] = Math.min(dp[newTime], dp[i] + (j + 1) * moveCost + digits[j] * pushCost);
                    }
                }
            }
        }
        return dp[targetSeconds];
    }
}