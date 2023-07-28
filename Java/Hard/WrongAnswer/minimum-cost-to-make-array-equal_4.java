class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long res = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                res += Math.min(cost[i], cost[i - 1]);
                if (cost[i] < cost[i - 1]) {
                    nums[i] = nums[i] + 1;
                } else {
                    nums[i - 1] = nums[i - 1] + 1;
                }
            }
        }
        return res;
    }
}