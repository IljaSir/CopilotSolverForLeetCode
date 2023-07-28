class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = forest.get(i).get(j);
                if (v > 1) trees.add(new int[]{v, i, j});
            }
        }
        Collections.sort(trees, (a, b) -> a[0] - b[0]);
        int ans = 0, sr = 0, sc = 0;
        for (int[] tree: trees) {
            int d = dist(forest, sr, sc, tree[1], tree[2]);
            if (d < 0) return -1;
            ans += d;
            sr = tree[1]; sc = tree[2];
        }
        return ans;
    }

    public int dist(List<List<Integer>> forest, int r1, int c1, int r2, int c2) {
        int m = forest.size(), n = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r1, c1});
        boolean[][] seen = new boolean[m][n];
        seen[r1][c1] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int d = 0;
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; --sz) {
                int[] rc = queue.poll();
                if (rc[0] == r2 && rc[1] == c2) return d;
                for (int[] dir: dirs) {
                    int nr = rc[0] + dir[0], nc = rc[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen[nr][nc] && forest.get(nr).get(nc) > 0) {
                        queue.offer(new int[]{nr, nc});
                        seen[nr][nc] = true;
                    }
                }
            }
            d++;
        }
        return -1;
    }
}