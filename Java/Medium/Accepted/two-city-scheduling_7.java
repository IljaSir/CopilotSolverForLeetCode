class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n = costs.length/2;
        int res = 0;
        int[] diff = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            diff[i] = costs[i][0] - costs[i][1];
            res += costs[i][1];
        }
        Arrays.sort(diff);
        for (int i = 0; i < n; i++) {
            res += diff[i];
        }
        return res;
    }
}