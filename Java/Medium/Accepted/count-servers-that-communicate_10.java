class Solution {
    public int countServers(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m], cols = new int[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                    count++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }
}