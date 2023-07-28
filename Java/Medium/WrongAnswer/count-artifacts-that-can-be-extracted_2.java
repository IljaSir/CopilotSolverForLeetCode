class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        
        int[][] grid = new int[n][n];
        for(int[] a : artifacts){
            for(int i=a[0]; i<=a[2]; i++){
                for(int j=a[1]; j<=a[3]; j++){
                    grid[i][j] = 1;
                }
            }
        }
        int count = 0;
        for(int[] d : dig){
            if(grid[d[0]][d[1]] == 1){
                count++;
                grid[d[0]][d[1]] = 0;
            }
        }
        return count;
    }
}