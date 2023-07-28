class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        while(col > 0) {
            int max = 0;
            int maxIndex = 0;
            for(int i = 0; i < row; i++) {
                int maxRow = 0;
                for(int j = 0; j < col; j++) {
                    maxRow = Math.max(maxRow, grid[i][j]);
                }
                if(maxRow > max) {
                    max = maxRow;
                    maxIndex = i;
                }
            }
            ans += max;
            for(int i = maxIndex; i < row - 1; i++) {
                grid[i] = grid[i + 1];
            }
            row--;
            col--;
        }
        return ans;
    }
}