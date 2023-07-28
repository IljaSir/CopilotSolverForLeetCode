class Solution {
    public int maxSum(int[][] grid) {
        
        int sum = Integer.MIN_VALUE;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                int curr = grid[i][j] + grid[i - 1][j] + grid[i + 1][j] + grid[i - 1][j - 1] + grid[i - 1][j + 1] + grid[i + 1][j - 1] + grid[i + 1][j + 1];
                sum = Math.max(curr, sum);
            }
        }
        return sum;
    }
}