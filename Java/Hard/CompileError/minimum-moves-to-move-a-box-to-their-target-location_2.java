class Solution {
    public int minPushBox(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] box = new int[2];
        int[] target = new int[2];
        int[] player = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                }
                if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                }
                if (grid[i][j] == 'S') {
                    player[0] = i;
                    player[1] = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{box[0], box[1], player[0], player[1]});
        Set<String> visited = new HashSet<>();
        visited.add(box[0] + " " + box[1] + " " + player[0] + " " + player[1]);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int bx = cur[0];
                int by = cur[1];
                int px = cur[2];
                int py = cur[3];
                if (bx == target[0] && by == target[1]) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int dx = bx - px;
                    int dy = by - py;
                    int nbx = bx + dx;
                    int nby = by + dy;
                    int npx = bx;
                    int npy = by;
                    if (nbx < 0 || nbx >= m || nby < 0 || nby >= n || grid[nbx][nby] == '#') {
                        continue;
                    }
                    if (npx < 0 || npx >= m || npy < 0 || npy >= n || grid[npx][npy] == '#') {
                        continue;
                    }
                    if (visited.add
    }
}