class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1) {
                        continue;
                    }
                    if (x == n - 1 && y == n - 1) {
                        return step;
                    }
                    grid[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}