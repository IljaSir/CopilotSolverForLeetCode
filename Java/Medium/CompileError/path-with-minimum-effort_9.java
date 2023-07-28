class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        // Binary Search
        // Time: O(mnlog(max-min))
        // Space: O(mn)
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 1000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!reachable(heights, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean reachable(int[][] heights, int effort) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            if (i == m - 1 && j == n - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && Math.abs(heights[x][y] - heights[i][j]) <= effort) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}