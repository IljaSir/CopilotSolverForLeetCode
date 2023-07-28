class Solution {
    public int minimumCost(int[] cost) {
        
        Arrays.sort(cost);
        int sum = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (i % 3 != 2) {
                sum += cost[i];
            }
        }
        return sum;
    }
}