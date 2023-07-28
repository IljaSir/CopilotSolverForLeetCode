class Solution {
    public int[] findBall(int[][] grid) {
        
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int r = 0, c = i;
            while (r < grid.length) {
                if (grid[r][c] == 1) {
                    if (c == grid[0].length - 1 || grid[r][c + 1] == -1) {
                        ans[i] = -1;
                        break;
                    }
                    r++;
                    c++;
                } else {
                    if (c == 0 || grid[r][c - 1] == 1) {
                        ans[i] = -1;
                        break;
                    }
                    r++;
                    c--;
                }
            }
            if (r == grid.length) {
                ans[i] = c;
            }
        }
        return ans;
    }
}