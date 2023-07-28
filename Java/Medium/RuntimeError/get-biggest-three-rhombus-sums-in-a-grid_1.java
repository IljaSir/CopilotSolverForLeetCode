class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        Set<Integer> set = new TreeSet<>((a, b) -> b - a);
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    int len = 0;
                    while (x > 0 && y > 0 && x <= m && y <= n) {
                        int cur = sum[x][y] - sum[x - len - 1][y] - sum[x][y - len - 1] + sum[x - len - 1][y - len - 1];
                        set.add(cur);
                        len++;
                        x += dx[k];
                        y += dy[k];
                    }
                }
            }
        }
        int[] ans = new int[3];
        int idx = 0;
        for (int num : set) {
            if (idx == 3) {
                break;
            }
            ans[idx++] = num;
        }
        return Arrays.copyOf(ans, idx);
    }
}