class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[1];
            int y = cur[2];
            if (x == m - 1 && y == n - 1) {
                return cur[0];
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int cost = 0;
                if (grid[x][y] != i + 1) {
                    cost = 1;
                }
                if (dist[nx][ny] > cur[0] + cost) {
                    dist[nx][ny] = cur[0] + cost;
                    pq.offer(new int[]{dist[nx][ny], nx, ny});
                }
            }
        }
        return -1;
    }
}