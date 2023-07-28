class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        if (n == 0 || grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0) {
                        queue.offer(new int[] {nextX, nextY});
                        grid[nextX][nextY] = 1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}