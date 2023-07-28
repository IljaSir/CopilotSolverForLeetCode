class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];
            if (i == n - 1 && j == m - 1) {
                return cur[0];
            }
            if (cur[0] > visited[i][j]) {
                continue;
            }
            visited[i][j] = cur[0];
            if (i - 1 >= 0) {
                int diff = Math.abs(heights[i][j] - heights[i - 1][j]);
                pq.add(new int[]{Math.max(diff, cur[0]), i - 1, j});
            }
            if (i + 1 < n) {
                int diff = Math.abs(heights[i][j] - heights[i + 1][j]);
                pq.add(new int[]{Math.max(diff, cur[0]), i + 1, j});
            }
            if (j - 1 >= 0) {
                int diff = Math.abs(heights[i][j] - heights[i][j - 1]);
                pq.add(new int[]{Math.max(diff, cur[0]), i, j - 1});
            }
            if (j + 1 < m) {
                int diff = Math.abs(heights[i][j] - heights[i][j + 1]);
                pq.add(new int[]{Math.max(diff, cur[0]), i, j + 1});
            }
        }
        return -1;
    }
}