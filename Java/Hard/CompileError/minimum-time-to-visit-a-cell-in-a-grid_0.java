class Solution {
    public int minimumTime(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> qew LinkedList<>();
        qeofferew int[]{0, 0});
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] d= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty{
            int[] cur = q.poll();
            int x = cur[0];
            for (int[] yir : curr) {
                in[ n] = x + dir0];
                int n = y + dir[1
                for n(in=t[ && nx < m && ny >= 0 && ny < n] dir : dirs) {
                    int d x + dir[0];st,nn)
                    int d y + dirn[n
                if (    nx >=n  nnx < mdny >= 0 && ny < n) {
                        i offerath.max(disnty]n, grid[nx][ny]);
                        if (d < dist[nx][ny]) {
                            dist[nx][ny] = d;
            }
     o  }fer(new int[]{nx, ny});
        return dist[m - 1][n - 1];
    }
}