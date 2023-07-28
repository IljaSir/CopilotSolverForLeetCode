class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row - 2; i++){
            for(int j = 0; j < col - 2; j++){
                if(grid[i + 1][j + 1] != 5) continue;
                if(isMagic(grid, i, j)) res++;
            }
        }
        return res;
    }
    private boolean isMagic(int[][] grid, int i, int j){
        int[] nums = new int[16];
        for(int r = i; r < i + 3; r++){
            for(int c = j; c < j + 3; c++){
                if(grid[r][c] < 1 || grid[r][c] > 9) return false;
                if(nums[grid[r][c]] > 0) return false;
                nums[grid[r][c]]++;
            }
        }
        if(grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) return false;
        if(grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != 15) return false;
        if(grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) return false;
        if(grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) return false;
        if(grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != 15) return false;
        if(grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) return false;
        if(grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) return false;
        if(grid[i][j + 2] + grid[i + 1][j + 1] + grid[i
    }
}