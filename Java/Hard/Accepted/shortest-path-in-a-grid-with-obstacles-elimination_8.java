class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        visited[0][0][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    int nextK = cur[2];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }
                    if (grid[nextX][nextY] == 1) {
                        nextK++;
                    }
                    if (nextK > k || visited[nextX][nextY][nextK]) {
                        continue;
                    }
                    queue.add(new int[]{nextX, nextY, nextK});
                    visited[nextX][nextY][nextK] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}