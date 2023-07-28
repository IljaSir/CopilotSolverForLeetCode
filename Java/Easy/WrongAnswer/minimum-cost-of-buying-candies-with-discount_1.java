class Solution {
    public int minimumCost(int[] cost) {
        
        Arrays.sort(cost);
        int sum = 0;
        for (int i = 0; i < cost.length; i++) {
            if (i % 3 != 2) {
                sum += cost[i];
            }
        }
        return sum;
    }
}