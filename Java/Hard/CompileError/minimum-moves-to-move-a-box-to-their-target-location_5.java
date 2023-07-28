class Solution {
    public int minPushBox(char[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[] box = new int[2], target = new int[2], player = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                } else if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                } else if (grid[i][j] == 'S') {
                    player[0] = i;
                    player[1] = j;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{box[0], box[1], player[0], player[1]});
        Set<String> visited = new HashSet<>();
        visited.add(box[0] + "," + box[1] + "," + player[0] + "," + player[1]);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == target[0] && cur[1] == target[1]) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    int px = cur[0] - dir[0], py = cur[1] - dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '#') {
                        continue;
                    }
                    if (x == cur[2] && y == cur[3]) {
                        if (px == target[0] && py == target[1]) {
                            return res + 1;
                        }
                        if (px < 0 || px >= m || py < 0 || py >= n || grid[px
    }
}