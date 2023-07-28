class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] r = new int[4];
                    r[0] = i;
                    r[1] = j;
                    dfs(land, visited, i, j, r);
                    res.add(r);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    
    private void dfs(int[][] land, boolean[][] visited, int i, int j, int[] r) {
        int m = land.length;
        int n = land[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || land[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        r[2] = Math.max(r[2], i);
        r[3] = Math.max(r[3], j);
        dfs(land, visited, i - 1, j, r);
        dfs(land, visited, i + 1, j, r);
        dfs(land, visited, i, j - 1, r);
        dfs(land, visited, i, j + 1, r);
    }
}