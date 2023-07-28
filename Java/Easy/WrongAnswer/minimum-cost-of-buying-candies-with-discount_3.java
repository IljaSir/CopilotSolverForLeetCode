class Solution {
    public int minimumCost(int[] cost) {
        
        Arrays.sort(cost);
        int sum = 0;
        for (int i = 0; i < cost.length; i++) {
            sum += cost[i];
            i += 2;
        }
        return sum;
    }
}