class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        pq.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];
        int time = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            time = Math.max(time, grid[cur[0]][cur[1]]);
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                return time;
            }
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                pq.offer(new int[]{row, col});
            }
        }
        return -1;
    }
}