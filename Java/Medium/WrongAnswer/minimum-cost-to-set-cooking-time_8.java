class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int[] dp = new int[100];
        dp[startAt] = 0;
        for (int i = startAt + 1; i < 100; ++i) {
            dp[i] = dp[i - 1] + moveCost;
        }
        for (int i = startAt - 1; i >= 0; --i) {
            dp[i] = dp[i + 1] + moveCost;
        }
        for (int i = 0; i < 100; ++i) {
            dp[i] += Math.min(i, 100 - i) * pushCost;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 100; ++i) {
            int time = i * 60 + dp[i % 10] + dp[i / 10];
            if (time <= targetSeconds) {
                min = Math.min(min, (targetSeconds - time) * pushCost);
            }
        }
        return min;
    }
}