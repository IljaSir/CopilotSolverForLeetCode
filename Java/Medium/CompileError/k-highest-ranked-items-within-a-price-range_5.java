class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[2] != b[2]) return a[2] - b[2];
            return a[3] - b[3];
        });
        pq.offer(new int[]{0, grid[start[0]][start[1]], start[0], start[1]});
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[2], y = cur[3];
            for (int[] dir : dirs) {
                int i = x + dir[0], j = y + dir[1];
                if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) continue;
                if (dist[i][j] > dist[x][y] + 1) {
                    dist[i][j] = dist[x][y] + 1;
                    pq.offer(new int[]{dist[i][j], grid[i][j], i, j});
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] != Integer.MAX_VALUE && grid[i][j] >= pricing[0] && grid[i][j] <= pricing[1]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        Collections.sort(res, (a, b) -> {
            if (dist[a.get(0)][a.get(1)] != dist[b.get(0)][b.get(1)]) return dist[b.get(0)][
    }
}