class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int[] row2 = new int[m];
        int[] col2 = new int[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                    count++;
                }
            }
        }
        int[] row3 = new int[m];
        int[] col3 = new int[n];
        int[] row4 = new int[m];
        int[] col4 = new int[n];
        int count2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    row3[i]++;
                    col3[j]++;
                    count2++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    row4[i]++;
                    col4[j]++;
                    count2++;
                }
            }
        }
        int count3 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row2[i]++;
                    col2[j]++;
                    count3++;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        if (count2 == 0) {
            return false;
        }
        if (count3 == 0) {
            return true;
        }
        if (count == count3) {
            return true;
        }
        if (count == count2) {
            return false;
        }
        return true;
    }
}