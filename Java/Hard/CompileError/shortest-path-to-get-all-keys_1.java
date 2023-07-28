class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length, n = grid[0].length();
        int[] start = new int[2];
        int keys = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    keys++;
                }
            }
        }
        return bfs(grid, start, keys);
    }
    
    private int bfs(String[] grid, int[] start, int keys) {
        int m = grid.length, n = grid[0].length();
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start[0] + "," + start[1] + "," + 0);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], k = cur[2];
                if (k == (1 << keys) - 1) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx].charAt(ny) == '#') {
                        continue;
                    }
                    int nk = k;
                    if (grid[nx].charAt(ny) >= 'a' && grid[nx].charAt(ny) <= 'f') {
                        nk |= (1 << (grid[nx].charAt(ny) - 'a'));
                    }
                    if (grid[nx].charAt(ny) >= 'A' && grid[nx].charAt(ny) <= 'F') {
                        if ((nk & (1 << (grid[nx].charAt
    }
}