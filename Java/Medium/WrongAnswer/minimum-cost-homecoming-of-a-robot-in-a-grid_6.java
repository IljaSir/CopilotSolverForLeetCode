class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        
        int m = rowCosts.length;
        int n = colCosts.length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[startPos[0]][startPos[1]] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{startPos[0], startPos[1], 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int c = cur[2];
            if (x == homePos[0] && y == homePos[1]) {
                return c;
            }
            if (x > 0) {
                int tmp = cost[x - 1][y] + rowCosts[x];
                if (tmp < cost[x][y]) {
                    cost[x][y] = tmp;
                    pq.offer(new int[]{x - 1, y, tmp});
                }
            }
            if (x < m - 1) {
                int tmp = cost[x + 1][y] + rowCosts[x + 1];
                if (tmp < cost[x][y]) {
                    cost[x][y] = tmp;
                    pq.offer(new int[]{x + 1, y, tmp});
                }
            }
            if (y > 0) {
                int tmp = cost[x][y - 1] + colCosts[y];
                if (tmp < cost[x][y]) {
                    cost[x][y] = tmp;
                    pq.offer(new int[]{x, y - 1, tmp});
                }
            }
            if (y < n - 1) {
                int tmp = cost[x][y + 1] + colCosts[y + 1];
                if (tmp < cost[x][y]) {
                    cost[x][y] = tmp;
                    pq.offer(new int[]{x, y + 1, tmp});
                }
            }
        }
        return -1;
    }
}