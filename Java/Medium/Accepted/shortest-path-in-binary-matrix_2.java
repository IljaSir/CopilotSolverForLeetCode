class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int N = grid.length;
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) {
            return -1;
        }
        if (N == 1) {
            return 1;
        }
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];
                    if (x == N - 1 && y == N - 1) {
                        return step + 1;
                    }
                    if (x >= 0 && x < N && y >= 0 && y < N && grid[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}