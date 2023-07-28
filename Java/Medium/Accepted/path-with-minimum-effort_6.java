class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length, n = heights[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0], r = cur[1], c = cur[2];
            if (r == m - 1 && c == n - 1) {
                return effort;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                int newEffort = Math.max(effort, Math.abs(heights[nr][nc] - heights[r][c]));
                if (newEffort < dp[nr][nc]) {
                    dp[nr][nc] = newEffort;
                    pq.offer(new int[]{newEffort, nr, nc});
                }
            }
        }
        return -1;
    }
}