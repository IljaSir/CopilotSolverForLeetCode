class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long costSum = 0;
        int prevNum = nums[0];
        long prevCost = cost[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prevNum) {
                costSum += Math.min(prevCost, cost[i]);
                prevCost = Math.max(prevCost, cost[i]);
            } else {
                prevNum = nums[i];
                prevCost = cost[i];
            }
        }
        return costSum;
    }
}