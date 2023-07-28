class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        int n = nums.length;
        long ans = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) {
                ans += Math.min(cost[i], cost[i - 1]);
                if (cost[i] < cost[i - 1]) {
                    nums[i] = nums[i - 1] + 1;
                }
            }
        }
        return ans;
    }
}