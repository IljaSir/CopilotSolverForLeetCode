class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        
        int[][] grid = new int[n][n];
        for (int[] artifact : artifacts) {
            for (int i = artifact[0]; i <= artifact[2]; i++) {
                for (int j = artifact[1]; j <= artifact[3]; j++) {
                    grid[i][j]++;
                }
            }
        }
        int res = 0;
        for (int[] digCell : dig) {
            int x = digCell[0], y = digCell[1];
            if (grid[x][y] > 0) {
                res++;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] > 0) {
                            if (i >= x && j >= y && i <= x + 1 && j <= y + 1) {
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}