class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        int m = heights.length, n = heights[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, p);
            dfs(heights, i, n - 1, a);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, p);
            dfs(heights, m - 1, j, a);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && heights[x][y] >= heights[i][j]) {
                dfs(heights, x, y, visited);
            }
        }
    }
}