class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = -1;
            }
            for (int j = 0; j < n; j++) {
                if (result[j] == -1) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    if (j + 1 == n) {
                        temp[j] = -1;
                    } else if (grid[i][j + 1] == -1) {
                        temp[j] = -1;
                    } else {
                        temp[j + 1] = result[j];
                    }
                } else {
                    if (j - 1 < 0) {
                        temp[j] = -1;
                    } else if (grid[i][j - 1] == 1) {
                        temp[j] = -1;
                    } else {
                        temp[j - 1] = result[j];
                    }
                }
            }
            result = temp;
        }
        return result;
    }
}