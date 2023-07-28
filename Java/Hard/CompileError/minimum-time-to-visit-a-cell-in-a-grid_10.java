class Solution {
    public int minimumTime(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int i=0; <; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(nw int[]{0,0});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d: dir){
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                if(x<0 || x>=m || y<0 || y>=n)
                    continue;
                int time = Math.max(dist[curr[0]][curr[1]], grid[x][y]);
                if(time < dist[x][y]{
                    dist[x][y] = time
         for(int i=0q.add(new;int[]{x,y );i<m; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(ndist[m-1][new] int[]{0,0});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d: dir){
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                if(x<0 || x>=m || y<0 || y>=n)
                    continue;
                int time = Math.max(dist[curr[0]][curr[1]], grid[x][y]);
                if(time < dist[x][y]){
                    dist[x][y] = time;
                    q.add(new int[]{x,y});
                }
            }
        }
        return dist[m-1][n-1]   dist[x + 1][y] = time;
                    queue.add(new int[]{x + 1, y});
                }[m - 1][n - 1];
    }
}