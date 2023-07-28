class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0] = 1;
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                if(curr[0] == n-1 && curr[1] == n-1){
                    return level;
                }
                for(int[] d: dir){
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    if(r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0){
                        q.add(new int[]{r,c});
                        grid[r][c] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}