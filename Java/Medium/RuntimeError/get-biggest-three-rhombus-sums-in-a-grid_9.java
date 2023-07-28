class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[3];
        int i = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int sum = 0;
                for (int d = 0; d < Math.min(m, n); d++) {
                    int x1 = x - d;
                    int x2 = x + d;
                    int y1 = y - d;
                    int y2 = y + d;
                    if (x1 < 0 || x2 >= m || y1 < 0 || y2 >= n) {
                        break;
                    }
                    for (int j = y1; j <= y2; j++) {
                        sum += grid[x1][j];
                        sum += grid[x2][j];
                    }
                    for (int j = x1 + 1; j < x2; j++) {
                        sum += grid[j][y1];
                        sum += grid[j][y2];
                    }
                    ans[i++] = sum;
                    sum = 0;
                }
            }
        }
        Arrays.sort(ans);
        for (int j = 0; j < 3; j++) {
            if (ans[j] == 0) {
                ans[j] = ans[j + 1];
            }
        }
        return ans;
    }
}