class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long totalCost = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                if (cost[i] < cost[i + 1]) {
                    totalCost += cost[i];
                } else {
                    totalCost += cost[i + 1];
                    cost[i + 1] = cost[i];
                }
            }
        }
        return totalCost;
    }
}