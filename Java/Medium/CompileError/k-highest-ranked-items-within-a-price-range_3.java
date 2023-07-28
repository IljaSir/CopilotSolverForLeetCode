class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            return a[3] - b[3];
        });
        pq.offer(new int[]{0, grid[start[0]][start[1]], start[0], start[1]});
        dist[start[0]][start[1]] = 0;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], p = top[1], x = top[2], y = top[3];
            if (d > dist[x][y]) {
                continue;
            }
            if (p >= pricing[0] && p <= pricing[1]) {
                pq.offer(new int[]{d, p, x, y});
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0 && d + 1 < dist[nx][ny]) {
                    dist[nx][ny] = d + 1;
                    pq.offer(new int[]{d + 1, grid[nx][ny], nx, ny});
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(top
    }
}