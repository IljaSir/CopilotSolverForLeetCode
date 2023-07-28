class Solution {
    public int minimumCost(int[] cost) {
        
        Arrays.sort(cost);
        int sum = 0;
        int n = cost.length;
        for (int i = n - 1; i >= 0; i -= 3) {
            sum += cost[i];
        }
        return sum;
    }
}