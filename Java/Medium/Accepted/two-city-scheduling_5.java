class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n = costs.length / 2;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += costs[i][0] + costs[i + n][1];
        }
        return sum;
    }
}