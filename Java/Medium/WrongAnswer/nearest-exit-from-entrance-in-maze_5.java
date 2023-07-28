class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length, n = maze[0].length;
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        int steps = 0;
        while(!q.isEmpty()){
            steps++;
            for(int i=q.size(); i>0; i--){
                int[] cur = q.poll();
                for(int[] d: dir){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] != '.')
                        continue;
                    if(x == 0 || x == m-1 || y == 0 || y == n-1)
                        return steps;
                    maze[x][y] = '+';
                    q.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}