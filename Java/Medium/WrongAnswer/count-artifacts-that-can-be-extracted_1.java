class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        
        int[][] grid = new int[n][n];
        for(int[] artifact : artifacts) {
            for(int i = artifact[0]; i <= artifact[2]; i++) {
                for(int j = artifact[1]; j <= artifact[3]; j++) {
                    grid[i][j]++;
                }
            }
        }
        int count = 0;
        for(int[] d : dig) {
            if(grid[d[0]][d[1]] > 0) {
                grid[d[0]][d[1]]--;
                if(grid[d[0]][d[1]] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}