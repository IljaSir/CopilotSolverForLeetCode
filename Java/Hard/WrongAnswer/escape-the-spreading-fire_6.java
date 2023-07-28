class Solution {
    public int maximumMinutes(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            int d = dist[x][y];
            if(x > 0 && grid[x - 1][y] != 2 && d + 1 < dist[x - 1][y]) {
                dist[x - 1][y] = d + 1;
                queue.add(new int[]{x - 1, y});
            }
            if(x < m - 1 && grid[x + 1][y] != 2 && d + 1 < dist[x + 1][y]) {
                dist[x + 1][y] = d + 1;
                queue.add(new int[]{x + 1, y});
            }
            if(y > 0 && grid[x][y - 1] != 2 && d + 1 < dist[x][y - 1]) {
                dist[x][y - 1] = d + 1;
                queue.add(new int[]{x, y - 1});
            }
            if(y < n - 1 && grid[x][y + 1] != 2 && d + 1 < dist[x][y + 1]) {
                dist[x][y + 1] = d + 1;
                queue.add(new int[]{x, y + 1});
            }
        }
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int d = dist[i][j];
                    if(d == Integer.MAX_VALUE) return -1;
                    max = Math.max(max, d);
                }
            }
        }
        return max;
    }
}