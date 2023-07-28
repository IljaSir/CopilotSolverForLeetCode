class Solution {
    public int orangesRotting(int[][] grid) {
        
        int fresh = 0;
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j)
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if (grid[i][j] == 1)
                    fresh++;
        int ans = 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; ++k) {
                int[] pos = q.poll();
                for (int[] dir: dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != 1)
                        continue;
                    grid[x][y] = 2;
                    fresh--;
                    q.add(new int[]{x, y});
                }
            }
            ans++;
        }
        return fresh == 0 ? Math.max(ans-1, 0) : -1;
    }
}