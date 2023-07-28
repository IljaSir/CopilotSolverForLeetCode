class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int m = grid.length, n = grid[0].length;
        int low = pricing[0], high = pricing[1];
        int row = start[0], col = start[1];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[2] != b[2]) return a[2] - b[2];
            return a[3] - b[3];
        });
        boolean[][] visited = new boolean[m][n];
        visited[row][col] = true;
        pq.offer(new int[]{0, grid[row][col], row, col});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], p = cur[1], r = cur[2], c = cur[3];
            if (p >= low && p <= high) {
                if (k == 1) return Arrays.asList(Arrays.asList(r, c));
                k--;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc] || grid[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                pq.offer(new int[]{d + 1, grid[nr][nc], nr, nc});
            }
        }
        return new ArrayList<>();
    }
}