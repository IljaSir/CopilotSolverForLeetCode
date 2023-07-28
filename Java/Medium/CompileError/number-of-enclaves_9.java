class Solution {
    public int numEnclaves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    dfs(grid, visited, i, j);
                }
        int count = 0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(grid[i][j] == 1)
                    count++;
        return count;
    }
}