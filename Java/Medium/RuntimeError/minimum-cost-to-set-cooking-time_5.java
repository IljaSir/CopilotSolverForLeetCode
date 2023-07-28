class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int[] dp = new int[4];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[startAt] = 0;
        for (int i = 0; i < targetSeconds; i++) {
            int[] ndp = new int[4];
            Arrays.fill(ndp, Integer.MAX_VALUE);
            for (int j = 0; j < 4; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;
                for (int k = 0; k < 10; k++) {
                    int cost = dp[j] + Math.abs(k - j) * moveCost + k * pushCost;
                    ndp[k] = Math.min(ndp[k], cost);
                }
            }
            dp = ndp;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                int cost = dp[i] + Math.abs(j - i) * moveCost + j * pushCost;
                res = Math.min(res, cost);
            }
        }
        return res;
    }
}