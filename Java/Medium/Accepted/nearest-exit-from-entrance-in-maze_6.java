class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if((x == 0 || y == 0 || x == m - 1 || y == n - 1) && (x != entrance[0] || y != entrance[1])) {
                    return step;
                }
                for(int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.') {
                        queue.offer(new int[]{nx,ny});
                        maze[nx][ny] = '+';
                    }
                }
            }
            step++;
        }
        return -1;
    }
}