class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = i;
            while (x < m) {
                if (grid[x][y] == 1) {
                    if (y == n - 1 || grid[x][y + 1] == -1) {
                        ans[i] = -1;
                        break;
                    } else {
                        y++;
                    }
                } else {
                    if (y == 0 || grid[x][y - 1] == 1) {
                        ans[i] = -1;
                        break;
                    } else {
                        y--;
                    }
                }
                x++;
            }
            if (x == m) {
                ans[i] = y;
            }
        }
        return ans;
    }
}