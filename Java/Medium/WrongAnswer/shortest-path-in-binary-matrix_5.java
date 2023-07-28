class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == n-1 && cur[1] == n-1) return grid[n-1][n-1];
            for(int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1) continue;
                grid[x][y] = grid[cur[0]][cur[1]] + 1;
                queue.add(new int[]{x, y});
            }
        }
        return -1;
    }
}