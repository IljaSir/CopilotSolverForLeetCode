class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                f[i][j] = forest.get(i).get(j);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (f[i][j] > 1) {
                    pq.offer(new int[]{i, j, f[i][j]});
                }
            }
        }
        int[] start = new int[]{0, 0};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = bfs(f, start, tree);
            if (step == -1) {
                return -1;
            }
            res += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return res;
    }
    private int bfs(int[][] f, int[] start, int[] tree) {
        int m = f.length;
        int n = f[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int step = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = q.poll();
                if (cur[0] == tree[0] && cur[1] == tree[1]) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0
    }
}