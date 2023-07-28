class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    pq.add(new int[]{i,j,heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            for(int[] dir:dirs){
                int x = curr[0]+dir[0];
                int y = curr[1]+dir[1];
                if(x<0 || x>=m || y<0 || y>=n || visited[x][y]) continue;
                visited[x][y] = true;
                res += Math.max(0,curr[2]-heightMap[x][y]);
                pq.add(new int[]{x,y,Math.max(curr[2],heightMap[x][y])});
            }
        }
        return res;
    }
}