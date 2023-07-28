class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        int[][] res = new int[rows * cols][2];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{rCenter, cCenter});
        visited[rCenter][cCenter] = true;
        int idx = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            res[idx++] = cur;
            for (int[] dir : dirs) {
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return res;
    }
}