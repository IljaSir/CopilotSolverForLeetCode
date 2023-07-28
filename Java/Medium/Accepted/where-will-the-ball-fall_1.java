class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[j] == -1) {
                    continue;
                }
                if (grid[i][res[j]] == 1) {
                    if (res[j] + 1 >= n || grid[i][res[j] + 1] == -1) {
                        res[j] = -1;
                    } else {
                        res[j]++;
                    }
                } else {
                    if (res[j] - 1 < 0 || grid[i][res[j] - 1] == 1) {
                        res[j] = -1;
                    } else {
                        res[j]--;
                    }
                }
            }
        }
        return res;
    }
}