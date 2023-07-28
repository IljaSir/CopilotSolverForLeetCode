class Solution {
    public int orangesRotting(int[][] grid) {
        
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                for (int[] d : dirs) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    fresh--;
                    q.offer(new int[]{x, y});
                }
            }
            if (!q.isEmpty()) {
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}