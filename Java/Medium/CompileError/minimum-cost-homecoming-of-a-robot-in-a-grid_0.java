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
        pq.offer(new int[]{startPos[0], startPos[1], 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];
            if (x == homePos[0] && y == homePos[1]) {
                return cost;
            }
            if (dp[x][y] != cost) {
                continue;
            }
            if (x > 0) {
                int nextX = x - 1;
                int nextY = y;
                int nextCost = cost + rowCosts[nextX];
                if (dp[nextX][nextY] > nextCost) {
                    dp[nextX][nextY] = nextCost;
                    pq.offer(new int[]{nextX, nextY, nextCost});
                }
            }
            if (x < m - 1) {
                int nextX = x + 1;
                int nextY = y;
                int nextCost = cost + rowCosts[nextX];
                if (dp[nextX][nextY] > nextCost) {
                    dp[nextX][nextY] = nextCost;
                    pq.offer(new int[]{nextX, nextY, nextCost});
                }
            }
            if (y > 0) {
                int nextX = x;
                int nextY = y - 1;
                int nextCost = cost + colCosts[nextY];
                if (dp[nextX][nextY] > nextCost) {
                    dp[nextX][nextY] = nextCost;
                    pq.offer(new int[]{nextX, nextY, nextCost});
                }
            }
            if (y < n - 1) {
                int nextX = x;
                int nextY = y + 1
    }
}