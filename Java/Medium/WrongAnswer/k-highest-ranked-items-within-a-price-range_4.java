class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
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
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[]{0, grid[start[0]][start[1]], start[0], start[1]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[2];
            int y = cur[3];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if (cur[1] >= pricing[0] && cur[1] <= pricing[1]) {
                k--;
                if (k == 0) {
                    break;
                }
            }
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] != 0) {
                    pq.offer(new int[]{cur[0] + 1, grid[nx][ny], nx, ny});
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] && grid[i][j] >= pricing[0] && grid[i][j] <= pricing[1]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
}