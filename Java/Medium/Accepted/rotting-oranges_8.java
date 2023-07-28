class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] pos = q.poll();
                for(int[] dir:dirs){
                    int x = pos[0]+dir[0];
                    int y = pos[1]+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        fresh--;
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                    }
                }
            }
            if(!q.isEmpty()){
                ans++;
            }
        }
        return fresh==0?ans:-1;
    }
}