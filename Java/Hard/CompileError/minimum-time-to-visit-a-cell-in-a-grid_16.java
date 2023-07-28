class Solution {
    public int minimumTime(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], time = cur[2];
            if (x == m - 1 && y == n - 1) {
                return time;
            }
            for (int[] direction : directions) {
                int nx = x + direction[0], ny = y + direction[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nTime = Math.max(time, grid[nx][ny]);
                    if (nTime < visited[nx][ny]) {
                        visited[nx][ny] = nTime;
                        pq.offer(new int[]{nx, ny, nTime});
                    }
                }
            }
        }
        return -1
            }
            if (y > 0) {
                int time = Math.max(d, grid[x][y]) + grid[x][y - 1];
                if (time < dist[x][y - 1]) {
                    dist[x][y - 1] = time;
                    queue.add(new int[]{x, y - 1});
                }
            }
            if (y < n - 1) {
                int time = Math.max(d, grid[x][y]) + grid[x][y + 1];
                if (time < dist[x][y + 1]) {
                    dist[x][y + 1] = time;
                    queue.add(new int[]{x, y + 1});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}