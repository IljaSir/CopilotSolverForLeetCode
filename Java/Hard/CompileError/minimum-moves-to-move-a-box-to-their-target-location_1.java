class Solution {
    public int minPushBox(char[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[] player = new int[2], box = new int[2], target = new int[2];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'S') {
                    player[0] = i;
                    player[1] = j;
                } else if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                } else if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new int[]{player[0], player[1], box[0], box[1]});
        visited.add(player[0] + "_" + player[1] + "_" + box[0] + "_" + box[1]);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                if (cur[2] == target[0] && cur[3] == target[1]) return res;
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '#') continue;
                    int bx = cur[2], by = cur[3];
                    if (x == bx && y == by) {
                        bx += dir[0];
                        by += dir[1];
                        if (bx < 0 || bx >= m || by < 0 || by >= n || grid[bx][by] == '#') continue;
                    }
                    if (visited.add(x + "_" + y + "_" + bx + "_" + by)) {
                        queue
    }
}