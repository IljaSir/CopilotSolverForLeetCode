class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int m = forest.size(), n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tree = forest.get(i).get(j);
                if (tree > 1) {
                    pq.add(new int[]{i, j, tree});
                }
            }
        }
        int steps = 0, sr = 0, sc = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int tr = tree[0], tc = tree[1], dist = distance(forest, sr, sc, tr, tc);
            if (dist < 0) {
                return -1;
            }
            steps += dist;
            sr = tr;
            sc = tc;
        }
        return steps;
    }

    private int distance(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int m = forest.size(), n = forest.get(0).size();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        boolean[][] visited = new boolean[m][n];
        visited[sr][sc] = true;
        int dist = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == tr && cur[1] == tc) {
                    return dist;
                }
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || forest.get(r).get(c) == 0) {
                        continue;
                    }
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
            dist++;
        }
        return -1;
    }
}