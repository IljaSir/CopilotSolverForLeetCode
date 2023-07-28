class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, m - 1, j, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y] || heights[x][y] < heights[i][j]) {
                continue;
            }
            dfs(heights, x, y, visited);
        }
    }
}