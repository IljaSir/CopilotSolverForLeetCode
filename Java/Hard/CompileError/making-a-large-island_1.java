class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[] area = new int[n*n+2];
        int index = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    area[index] = dfs(grid, i, j, index);
                    index++;
                }
            }
        }
        int res = area[2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    int cur = 1;
                    HashSet<Integer> set = new HashSet<>();
                    if(i-1 >= 0 && grid[i-1][j] != 0) set.add(grid[i-1][j]);
                    if(i+1 < n && grid[i+1][j] != 0) set.add(grid[i+1][j]);
                    if(j-1 >= 0 && grid[i][j-1] != 0) set.add(grid[i][j-1]);
                    if(j+1 < n && grid[i][j+1] != 0) set.add(grid[i][j+1]);
                    for(int k : set){
                        cur += area[k];
                    }
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }
}