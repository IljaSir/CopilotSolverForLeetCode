class Solution {
    public int minimumCost(int[] cost) {
        
        Arrays.sort(cost);
        int n = cost.length;
        int sum = 0;
        for(int i = n - 1; i >= 0; i = i - 3){
            sum += cost[i];
        }
        return sum;
    }
}