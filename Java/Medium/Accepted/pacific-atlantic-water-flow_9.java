class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        if (m == 0) {
            return result;
        }
        int n = heights[0].length;
        if (n == 0) {
            return result;
        }
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, boolean[][] ocean, int i, int j, int pre) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || heights[i][j] < pre || ocean[i][j]) {
            return;
        }
        ocean[i][j] = true;
        dfs(heights, ocean, i - 1, j, heights[i][j]);
        dfs(heights, ocean, i + 1, j, heights[i][j]);
        dfs(heights, ocean, i, j - 1, heights[i][j]);
        dfs(heights, ocean, i, j + 1, heights[i][j]);
    }
}