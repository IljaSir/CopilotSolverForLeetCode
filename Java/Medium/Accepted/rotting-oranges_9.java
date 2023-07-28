class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[] {x, y});
                    count--;
                    if (count == 0) {
                        return minutes + 1;
                    }
                }
            }
            minutes++;
        }
        return -1;
    }
}