class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        long totalCost = 0;
        int i = 0;
        while (i < nums.length - 1) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                totalCost += cost[j];
                j++;
            }
            if (j < nums.length) {
                long minCost = cost[i];
                long maxCost = cost[i];
                for (int k = i + 1; k < j; k++) {
                    minCost = Math.min(minCost, cost[k]);
                    maxCost = Math.max(maxCost, cost[k]);
                }
                totalCost -= maxCost;
                totalCost += minCost;
            }
            i = j;
        }
        return totalCost;
    }
}