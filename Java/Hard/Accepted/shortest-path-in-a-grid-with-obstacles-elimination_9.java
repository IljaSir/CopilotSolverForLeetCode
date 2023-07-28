class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][][] memo = new int[m][n][k+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= k; l++) {
                    memo[i][j][l] = Integer.MAX_VALUE;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        memo[0][0][0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], l = cur[2];
            if (x == m - 1 && y == n - 1) return memo[x][y][l];
            for (int[] d : dir) {
                int i = x + d[0], j = y + d[1];
                if (i < 0 || i >= m || j < 0 || j >= n) continue;
                int nextL = l + grid[i][j];
                if (nextL > k || memo[i][j][nextL] <= memo[x][y][l] + 1) continue;
                memo[i][j][nextL] = memo[x][y][l] + 1;
                q.offer(new int[]{i,j,nextL});
            }
        }
        return -1;
    }
}