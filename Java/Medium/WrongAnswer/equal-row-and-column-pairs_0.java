class Solution {
    public int equalPairs(int[][] grid) {
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == grid[j][i]) {
                    count++;
                }
            }
        }
        return count;
    }
}