class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int n = maze.length;
        int m = maze[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1]});
        int[][] dist = new int[n][m];
        dist[entrance[0]][entrance[1]] = 1;
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int[] dir: dirs){
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                if(x < 0 || y < 0 || x >= n || y >= m || maze[x][y] == '+' || dist[x][y] != 0){
                    continue;
                }
                dist[x][y] = dist[p[0]][p[1]] + 1;
                q.add(new int[]{x, y});
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && maze[i][j] == '.' && dist[i][j] != 0){
                    ans = Math.min(ans, dist[i][j]);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans - 1;
    }
}