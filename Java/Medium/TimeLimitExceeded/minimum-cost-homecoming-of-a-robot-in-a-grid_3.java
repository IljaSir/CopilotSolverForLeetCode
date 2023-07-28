class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        
        int m = rowCosts.length;
        int n = colCosts.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[startPos[0]][startPos[1]] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {startPos[0], startPos[1], 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == homePos[0] && y == homePos[1]) {
                return dp[x][y];
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int cost = dp[x][y];
                    if (dir[0] == 0) {
                        cost += colCosts[ny];
                    } else {
                        cost += rowCosts[nx];
                    }
                    if (dp[nx][ny] > cost) {
                        dp[nx][ny] = cost;
                        pq.offer(new int[] {nx, ny, cost});
                    }
                }
            }
        }
        return -1;
    }
}