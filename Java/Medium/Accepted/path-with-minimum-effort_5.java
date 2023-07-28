class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] minEffort = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(minEffort[i], Integer.MAX_VALUE);
        }
        minEffort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int effort = cur[2];
            if (r == rows - 1 && c == cols - 1) {
                return effort;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i];
                int nc = c + dirs[i + 1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int newEffort = Math.max(effort, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (newEffort < minEffort[nr][nc]) {
                        minEffort[nr][nc] = newEffort;
                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }
        return 0;
    }
}