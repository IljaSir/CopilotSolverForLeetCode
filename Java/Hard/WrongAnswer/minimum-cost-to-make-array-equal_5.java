class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long result = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                if (cost[i] < cost[i - 1]) {
                    result += cost[i];
                    nums[i] = nums[i - 1] + 1;
                } else {
                    result += cost[i - 1];
                    nums[i - 1] = nums[i] + 1;
                }
            }
        }
        return result;
    }
}