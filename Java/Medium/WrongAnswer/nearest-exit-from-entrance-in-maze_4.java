class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        visited[entrance[0]][entrance[1]] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                if(isExit(curr,m,n)){
                    return steps;
                }
                for(int[] dir: dirs){
                    int x = curr[0]+dir[0];
                    int y = curr[1]+dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && !visited[x][y] && maze[x][y] == '.'){
                        q.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public boolean isExit(int[] curr, int m, int n){
        if(curr[0] == 0 || curr[1] == 0 || curr[0] == m-1 || curr[1] == n-1){
            return true;
        }
        return false;
    }
}