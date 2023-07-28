class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, 0, i, Integer.MIN_VALUE);
            dfs(heights, atlantic, m - 1, i, Integer.MIN_VALUE);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int x, int y, int pre) {
        int m = heights.length;
        int n = heights[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || heights[x][y] < pre || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        dfs(heights, visited, x + 1, y, heights[x][y]);
        dfs(heights, visited, x - 1, y, heights[x][y]);
        dfs(heights, visited, x, y + 1, heights[x][y]);
        dfs(heights, visited, x, y - 1, heights[x][y]);
    }
}