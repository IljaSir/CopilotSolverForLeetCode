class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        int[][] cells = new int[rows * cols][2];
        int[][] visited = new int[rows][cols];
        int i = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {rCenter, cCenter});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] == 1) {
                continue;
            }
            cells[i++] = cur;
            visited[r][c] = 1;
            queue.offer(new int[] {r - 1, c});
            queue.offer(new int[] {r + 1, c});
            queue.offer(new int[] {r, c - 1});
            queue.offer(new int[] {r, c + 1});
        }
        return cells;
    }
}