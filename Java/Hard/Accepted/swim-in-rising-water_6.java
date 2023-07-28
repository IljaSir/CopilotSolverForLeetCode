class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] visited = new int[n][n];
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = 1;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int currTime = curr[2];
            if(i == n - 1 && j == n - 1) {
                return currTime;
            }
            for(int[] dir : directions) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || visited[nextI][nextJ] == 1) {
                    continue;
                }
                visited[nextI][nextJ] = 1;
                pq.offer(new int[]{nextI, nextJ, Math.max(currTime, grid[nextI][nextJ])});
            }
        }
        return -1;
    }
}