class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        boolean[][] grid = new boolean[m][n];
        for(int[] wall : walls) {
            grid[wall[0]][wall[1]] = true;
        }
        int count = 0;
        for(int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            int i = x;
            int j = y;
            while(i >= 0) {
                if(grid[i][j]) {
                    break;
                }
                count++;
                i--;
            }
            i = x;
            j = y;
            while(i < m) {
                if(grid[i][j]) {
                    break;
                }
                count++;
                i++;
            }
            i = x;
            j = y;
            while(j >= 0) {
                if(grid[i][j]) {
                    break;
                }
                count++;
                j--;
            }
            i = x;
            j = y;
            while(j < n) {
                if(grid[i][j]) {
                    break;
                }
                count++;
                j++;
            }
        }
        return count;
    }
}