class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length, n = grid[0].length();
        int[][][] dist = new int[m][n][1<<6];
        int[] start = new int[2];
        int keys = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char c = grid[i].charAt(j);
                if(c == '@'){
                    start[0] = i;
                    start[1] = j;
                }
                if(c >= 'a' && c <= 'f'){
                    keys |= (1<<(c-'a'));
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], k = cur[2];
            if(dist[x][y][k] != 0) continue;
            dist[x][y][k] = 1;
            for(int[] d : dirs){
                int i = x + d[0], j = y + d[1];
                if(i < 0 || i >= m || j < 0 || j >= n || grid[i].charAt(j) == '#') continue;
                char c = grid[i].charAt(j);
                int newKey = k;
                if(c >= 'a' && c <= 'f'){
                    newKey |= (1<<(c-'a'));
                } else if(c >= 'A' && c <= 'F'){
                    if((k & (1<<(c-'A'))) == 0) continue;
                }
                if(dist[i][j][newKey] == 0){
                    queue.add(new int[]{i,j,newKey});
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<1<<6; i++){
            if((i & keys) == keys && dist[start[0]][start[1]][i] != 0){
                res = Math.min(res, dist[start[0]][start[1]][i] - 1);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}