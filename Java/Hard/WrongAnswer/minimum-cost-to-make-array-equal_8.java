class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long sum = 0;
        int max = nums[0];
        int maxCost = cost[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == max) {
                sum += Math.min(maxCost, cost[i]);
                maxCost = Math.max(maxCost, cost[i]);
            } else if (nums[i] > max) {
                max = nums[i];
                maxCost = cost[i];
            }
        }
        return sum;
    }
}