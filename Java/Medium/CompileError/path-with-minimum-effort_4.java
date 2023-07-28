class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[0];
            int y = top[1];
            int cost = top[2];
            
            if(cost > dp[x][y]) continue;
            
            if(x == n - 1 && y == m - 1) return cost;
            
            if(x + 1 < n) {
                int diff = Math.abs(heights[x][y] - heights[x + 1][y]);
                if(dp[x + 1][y] > Math.max(diff, cost)) {
                    dp[x + 1][y] = Math.max(diff, cost);
                    pq.add(new int[]{x + 1, y, dp[x + 1][y]});
                }
            }
            
            if(x - 1 >= 0) {
                int diff = Math.abs(heights[x][y] - heights[x - 1][y]);
                if(dp[x - 1][y] > Math.max(diff, cost)) {
                    dp[x - 1][y] = Math.max(diff, cost);
                    pq.add(new int[]{x - 1, y, dp[x - 1][y]});
                }
            }
            
            if(y + 1 < m) {
                int diff = Math.abs(heights[x][y] - heights[x][y + 1]);
                if(dp[x][y + 1] > Math.max(diff, cost)) {
                    dp[x][y + 1] = Math.max(diff, cost);
                    pq.add(new int[]{x, y + 1, dp[x][y + 1]});
                }
            }
            
            if(y - 1 >= 0) {
                int diff = Math.abs(heights[x][y] - heights[x][y - 1]);
                if(dp[x][y - 1] > Math.max(diff,
    }
}