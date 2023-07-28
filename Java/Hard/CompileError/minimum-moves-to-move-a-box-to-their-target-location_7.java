class Solution {
    public int minPushBox(char[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[] box = null;
        int[] target = null;
        int[] player = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    box = new int[]{i, j};
                } else if (grid[i][j] == 'T') {
                    target = new int[]{i, j};
                } else if (grid[i][j] == 'S') {
                    player = new int[]{i, j};
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new int[]{player[0], player[1], box[0], box[1]});
        visited.add(player[0] + "," + player[1] + "," + box[0] + "," + box[1]);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[2] == target[0] && cur[3] == target[1]) {
                    return ans;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '#') {
                        continue;
                    }
                    if (x == cur[2] && y == cur[3]) {
                        int bx = cur[2] + dir[0];
                        int by = cur[3] + dir[1];
                        if (bx < 0 || bx >= m || by < 0 || by >= n || grid[bx][by] == '#') {
                            continue;
                        }
                        if (!visited.contains(x + "," + y + "," + bx + "," + by)) {
                            q.offer(new int[]{x, y, bx
    }
}