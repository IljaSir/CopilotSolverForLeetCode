class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int c = cur[2];
            for (int k = 0; k < 4; k++) {
                int x = i + dir[k][0];
                int y = j + dir[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int nextCost = c + (grid[i][j] == k + 1 ? 0 : 1);
                    if (cost[x][y] > nextCost) {
                        cost[x][y] = nextCost;
                        pq.offer(new int[]{x, y, nextCost});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}