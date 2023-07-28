class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    trees.add(new int[]{h, i, j});
                }
            }
        }
        trees.sort((a, b) -> a[0] - b[0]);
        int x = 0, y = 0, steps = 0;
        for (int[] tree : trees) {
            int step = bfs(forest, x, y, tree[1], tree[2]);
            if (step < 0) return -1;
            steps += step;
            x = tree[1];
            y = tree[2];
        }
        return steps;
    }

    private int bfs(List<List<Integer>> forest, int x1, int y1, int x2, int y2) {
        int m = forest.size();
        int n = forest.get(0).size();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1, y1});
        boolean[][] visited = new boolean[m][n];
        visited[x1][y1] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == x2 && cur[1] == y2) return step;
                for (int[] d : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}