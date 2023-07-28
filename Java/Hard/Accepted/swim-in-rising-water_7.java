class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        boolean[][] visited = new boolean[n][n];
        int res = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            res = Math.max(res,cur[0]);
            visited[cur[1]][cur[2]] = true;
            if(cur[1]==n-1 && cur[2]==n-1) return res;
            for(int[] d:dir){
                int x = cur[1]+d[0];
                int y = cur[2]+d[1];
                if(x>=0 && x<n && y>=0 && y<n && !visited[x][y]){
                    pq.add(new int[]{grid[x][y],x,y});
                }
            }
        }
        return -1;
    }
}