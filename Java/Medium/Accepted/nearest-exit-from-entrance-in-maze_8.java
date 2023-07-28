class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length, n = maze[0].length;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                if((x==0 || x==m-1 || y==0 || y==n-1) && !(x==entrance[0] && y==entrance[1])){
                    return steps;
                }
                for(int[] d: dir){
                    int xx = x + d[0], yy = y + d[1];
                    if(xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]=='.' && !visited[xx][yy]){
                        q.add(new int[]{xx,yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}