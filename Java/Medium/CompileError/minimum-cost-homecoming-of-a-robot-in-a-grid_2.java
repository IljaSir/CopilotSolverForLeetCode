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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, startPos[0], startPos[1]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[1];
            int y = cur[2];
            if (x == homePos[0] && y == homePos[1]) {
                return cur[0];
            }
            if (x + 1 < m) {
                if (dp[x + 1][y] > dp[x][y] + rowCosts[x + 1]) {
                    dp[x + 1][y] = dp[x][y] + rowCosts[x + 1];
                    pq.offer(new int[] {dp[x + 1][y], x + 1, y});
                }
            }
            if (x - 1 >= 0) {
                if (dp[x - 1][y] > dp[x][y] + rowCosts[x]) {
                    dp[x - 1][y] = dp[x][y] + rowCosts[x];
                    pq.offer(new int[] {dp[x - 1][y], x - 1, y});
                }
            }
            if (y + 1 < n) {
                if (dp[x][y + 1] > dp[x][y] + colCosts[y + 1]) {
                    dp[x][y + 1] = dp[x][y] + colCosts[y + 1];
                    pq.offer(new int[] {dp[x][y + 1], x, y + 1});
                }
            }
            if (y - 1 >= 0) {
                if (dp[x][y - 1] > dp[x][y] + colCosts[y]) {
                    dp[x][y - 1] = dp[x][
    }
}