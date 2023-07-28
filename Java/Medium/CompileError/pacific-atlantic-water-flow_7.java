class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        // init
        for (int i = 0; i < m; i++) {
            pacificQueue.add(new int[]{i, 0});
            pacific[i][0] = true;
            atlanticQueue.add(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            pacificQueue.add(new int[]{0, i});
            pacific[0][i] = true;
            atlanticQueue.add(new int[]{m - 1, i});
            atlantic[m - 1][i] = true;
        }
        // bfs
        bfs(heights, pacific, pacificQueue);
        bfs(heights, atlantic, atlanticQueue);
        // result
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
}