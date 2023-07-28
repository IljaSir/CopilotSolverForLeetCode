class Solution {
    public int regionsBySlashes(String[] grid) {
        
        int n = grid.length;
        int[][] arr = new int[n*3][n*3];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i].charAt(j) == '/'){
                    arr[i*3][j*3+2] = 1;
                    arr[i*3+1][j*3+1] = 1;
                    arr[i*3+2][j*3] = 1;
                }else if(grid[i].charAt(j) == '\\'){
                    arr[i*3][j*3] = 1;
                    arr[i*3+1][j*3+1] = 1;
                    arr[i*3+2][j*3+2] = 1;
                }
            }
        }
        boolean[][] visited = new boolean[n*3][n*3];
        int count = 0;
        for(int i=0; i<n*3; i++){
            for(int j=0; j<n*3; j++){
                if(arr[i][j] == 0 && !visited[i][j]){
                    dfs(arr, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] arr, boolean[][] visited, int i, int j){
        if(i<0 || i>=arr.length || j<0 || j>=arr.length || visited[i][j] || arr[i][j] != 0){
            return;
        }
        visited[i][j] = true;
        dfs(arr, visited, i+1, j);
        dfs(arr, visited, i-1, j);
        dfs(arr, visited, i, j+1);
        dfs(arr, visited, i, j-1);
    }
}