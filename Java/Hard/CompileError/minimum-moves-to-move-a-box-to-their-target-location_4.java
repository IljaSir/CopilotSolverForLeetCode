class Solution {
    public int minPushBox(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] player = null;
        int[] box = null;
        int[] target = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    player = new int[]{i, j};
                } else if (grid[i][j] == 'B') {
                    box = new int[]{i, j};
                } else if (grid[i][j] == 'T') {
                    target = new int[]{i, j};
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{player[0], player[1], box[0], box[1]});
        Set<String> visited = new HashSet<>();
        visited.add(player[0] + "_" + player[1] + "_" + box[0] + "_" + box[1]);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[2] == target[0] && cur[3] == target[1]) {
                    return step;
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
                        if (!visited.contains(x + "_" + y + "_" + bx + "_" + by)) {
                            queue.offer(new int[]{x, y, bx,
    }
}