class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        
        int m = rowCosts.length, n = colCosts.length;
        int[][] dp = new int[m][n];
        int[][] cost = new int[m][n];
        dp[startPos[0]][startPos[1]] = 1;
        cost[startPos[0]][startPos[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(startPos);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x > 0 && dp[x - 1][y] == 0) {
                dp[x - 1][y] = 1;
                cost[x - 1][y] = cost[x][y] + rowCosts[x - 1];
                queue.offer(new int[] {x - 1, y});
            }
            if (x < m - 1 && dp[x + 1][y] == 0) {
                dp[x + 1][y] = 1;
                cost[x + 1][y] = cost[x][y] + rowCosts[x];
                queue.offer(new int[] {x + 1, y});
            }
            if (y > 0 && dp[x][y - 1] == 0) {
                dp[x][y - 1] = 1;
                cost[x][y - 1] = cost[x][y] + colCosts[y - 1];
                queue.offer(new int[] {x, y - 1});
            }
            if (y < n - 1 && dp[x][y + 1] == 0) {
                dp[x][y + 1] = 1;
                cost[x][y + 1] = cost[x][y] + colCosts[y];
                queue.offer(new int[] {x, y + 1});
            }
        }
        return cost[homePos[0]][homePos[1]];
    }
}