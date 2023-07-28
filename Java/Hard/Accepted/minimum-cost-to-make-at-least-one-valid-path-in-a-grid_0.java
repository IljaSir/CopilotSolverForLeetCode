class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int curCost = cur[2];
            if (r == m - 1 && c == n - 1) {
                return curCost;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                int nextCost = curCost;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (grid[r][c] != i + 1) {
                        nextCost++;
                    }
                    if (nextCost < cost[nr][nc]) {
                        cost[nr][nc] = nextCost;
                        pq.offer(new int[]{nr, nc, nextCost});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}