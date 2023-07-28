class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (cost[i] < cost[i - 1]) {
                    res += cost[i];
                    cost[i] = cost[i - 1];
                } else {
                    res += cost[i - 1];
                }
            }
        }
        return res;
    }
}