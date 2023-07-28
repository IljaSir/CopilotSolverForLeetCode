class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0], newCol = col + direction[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return distance;
    }
}