class Solution {
    public int minPushBox(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] player = new int[2];
        int[] box = new int[2];
        int[] target = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{player[0], player[1], box[0], box[1], 0});
        Set<String> visited = new HashSet<>();
        visited.add(player[0] + " " + player[1] + " " + box[0] + " " + box[1]);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == target[0] && cur[1] == target[1]) {
                return cur[4];
            }
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] direction : directions) {
                int px = cur[0] + direction[0];
                int py = cur[1] + direction[1];
                if (px < 0 || px >= m || py < 0 || py >= n || grid[px][py] == '#') {
                    continue;
                }
                int bx = cur[2];
                int by = cur[3];
                if (px == bx && py == by) {
                    bx += direction[0];
                    by += direction[1];
                    if (bx < 0 || bx >= m || by < 0 || by >= n || grid[bx][by] == '#') {
                        continue;
                    }
                }
                String key = px + " " + py + " " + bx + " " + by;
    }
}