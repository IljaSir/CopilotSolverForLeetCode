class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int[] dp = new int[10];
        int[] ndp = new int[10];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[startAt] = 0;
        for (int i = 0; i < targetSeconds; i++) {
            Arrays.fill(ndp, Integer.MAX_VALUE);
            for (int j = 0; j < 10; j++) {
                if (dp[j] == Integer.MAX_VALUE) {
                    continue;
                }
                int cost = dp[j] + pushCost;
                int next = (j + 1) % 10;
                ndp[next] = Math.min(ndp[next], cost + moveCost);
                next = (j + 9) % 10;
                ndp[next] = Math.min(ndp[next], cost + moveCost);
            }
            dp = ndp;
            ndp = new int[10];
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            int cost = dp[i];
            int[] nums = new int[4];
            nums[0] = i;
            for (int j = 1; j < 4; j++) {
                nums[j] = targetSeconds % 10;
                targetSeconds /= 10;
            }
            for (int j = 0; j < 4; j++) {
                cost += Math.abs(nums[j] - nums[3 - j]) * pushCost;
            }
            ret = Math.min(ret, cost);
        }
        return ret;
    }
}