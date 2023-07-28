class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int l = 0;
        int r = 1000000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (dfs(0, 0, mid, heights, m, n, dirs)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private boolean dfs(int i, int j, int mid, int[][] heights, int m, int n, int[][] dirs) {
        if (i < 0 || i >= m || j < 0 || j >= n || heights[i][j] == -1) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        heights[i][j] = -1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || heights[x][y] == -1) {
                continue;
            }
            if (Math.abs(heights[i][j] - heights[x][y]) > mid) {
                continue;
            }
            if (dfs(x, y, mid, heights, m, n, dirs)) {
                return true;
            }
        }
        return false;
    }
}