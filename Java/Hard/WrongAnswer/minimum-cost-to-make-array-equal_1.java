class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (cost[i] < cost[i - 1]) {
                    sum += cost[i];
                    cost[i] = cost[i - 1];
                } else {
                    sum += cost[i - 1];
                }
            }
        }
        return sum;
    }
}