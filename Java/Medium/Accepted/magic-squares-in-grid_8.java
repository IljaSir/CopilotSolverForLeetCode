class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int count = 0;
        for(int i = 0; i < grid.length - 2; i++){
            for(int j = 0; j < grid[0].length - 2; j++){
                if(grid[i + 1][j + 1] != 5) continue;
                if(isMagic(grid, i, j)) count++;
            }
        }
        return count;
    }
    
    private boolean isMagic(int[][] grid, int i, int j){
        int[] count = new int[10];
        for(int m = i; m < i + 3; m++){
            for(int n = j; n < j + 3; n++){
                if(grid[m][n] < 1 || grid[m][n] > 9 || count[grid[m][n]] == 1) return false;
                count[grid[m][n]] = 1;
            }
        }
        return (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15
                && grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15
                && grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15
                && grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15
                && grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == 15
                && grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15
                && grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15
                && grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] == 15);
    }
}