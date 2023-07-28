class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long result = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                if(cost[i] < cost[i - 1]) {
                    result += cost[i];
                    cost[i] = cost[i - 1];
                } else {
                    result += cost[i - 1];
                }
            }
        }
        return result;
    }
}