class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
            dfs(i, n - 1, heights, atlantic);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, heights, pacific);
            dfs(m - 1, i, heights, atlantic);
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

    private void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;
        visited[i][j] = true;
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && heights[x][y] >= heights[i][j]) {
                dfs(x, y, heights, visited);
            }
        }
    }
}