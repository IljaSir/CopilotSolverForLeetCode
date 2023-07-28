class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = forest.get(i).get(j);
            }
        }
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 1) {
                    trees.add(new int[]{grid[i][j], i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int x = 0, y = 0;
        for (int[] tree : trees) {
            int d = dist(grid, x, y, tree[1], tree[2]);
            if (d < 0) {
                return -1;
            }
            ans += d;
            x = tree[1];
            y = tree[2];
        }
        return ans;
    }
    
    private int dist(int[][] grid, int sx, int sy, int tx, int ty) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        queue.offer(new int[]{sx, sy, 0});
        seen[sx][sy] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == tx && p[1] == ty) {
                return p[2];
            }
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || seen[x][y] || grid[x][y] == 0) {
                    continue;
                }
    }
}