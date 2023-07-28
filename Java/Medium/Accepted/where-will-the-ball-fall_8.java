class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int x = 0;
            int y = i;
            while (x < m) {
                if (grid[x][y] == 1) {
                    if (y + 1 == n || grid[x][y + 1] == -1) {
                        res[i] = -1;
                        break;
                    } else {
                        ++y;
                        ++x;
                    }
                } else {
                    if (y - 1 == -1 || grid[x][y - 1] == 1) {
                        res[i] = -1;
                        break;
                    } else {
                        --y;
                        ++x;
                    }
                }
            }
            if (x == m) {
                res[i] = y;
            }
        }
        return res;
    }
}