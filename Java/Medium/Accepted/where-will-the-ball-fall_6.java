class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = i;
            for (int j = 0; j < m; j++) {
                if (grid[j][cur] == 1) {
                    if (cur == n - 1 || grid[j][cur + 1] == -1) {
                        cur = -1;
                        break;
                    }
                    cur++;
                } else {
                    if (cur == 0 || grid[j][cur - 1] == 1) {
                        cur = -1;
                        break;
                    }
                    cur--;
                }
            }
            res[i] = cur;
        }
        return res;
    }
}