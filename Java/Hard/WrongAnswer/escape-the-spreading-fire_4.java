class Solution {
    public int maximumMinutes(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 2 && distance[x][y] > distance[current[0]][current[1]] + 1) {
                    distance[x][y] = distance[current[0]][current[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, distance[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}