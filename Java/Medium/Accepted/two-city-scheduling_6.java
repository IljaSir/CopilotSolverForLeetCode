class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n = costs.length / 2;
        int[] refund = new int[n * 2];
        int minCost = 0;
        for (int i = 0; i < costs.length; ++i) {
            minCost += costs[i][0];
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < n; ++i) {
            minCost += refund[i];
        }
        return minCost;
    }
}