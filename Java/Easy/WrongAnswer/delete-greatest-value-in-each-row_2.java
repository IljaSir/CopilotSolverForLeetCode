class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }
            sum += max;
        }
        return sum;
    }
}