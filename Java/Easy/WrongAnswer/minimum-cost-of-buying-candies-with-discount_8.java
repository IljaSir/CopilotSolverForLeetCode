class Solution {
    public int minimumCost(int[] cost) {
        
        if (cost.length < 2) {
            return 0;
        }
        Arrays.sort(cost);
        int i = cost.length - 1;
        int sum = 0;
        while (i >= 0) {
            sum += cost[i];
            i -= 2;
        }
        return sum;
    }
}