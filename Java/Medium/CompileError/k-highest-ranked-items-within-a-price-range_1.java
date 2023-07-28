class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int low = pricing[0];
        int high = pricing[1];
        int row = start[0];
        int col = start[1];
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.get(0) == b.get(0) ? a.get(1) == b.get(1) ? a.get(2) == b.get(2) ? a.get(3) - b.get(3) : a.get(2) - b.get(2) : a.get(1) - b.get(1) : a.get(0) - b.get(0)
        );
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            if (grid[i][j] >= low && grid[i][j] <= high) {
                pq.offer(Arrays.asList(i + j, i, j, grid[i][j]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] != 0) {
                queue.offer(new int[]{i - 1, j});
                visited[i - 1][j] = true;
            }
            if (i < m - 1 && !visited[i + 1][j] && grid[i + 1][j] != 0) {
                queue.offer(new int[]{i + 1, j});
                visited[i + 1][j] = true;
            }
            if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] != 0) {
                queue.offer(new int[]{i, j - 1});
                visited[i][j - 1] = true;
            }
            if (j < n - 1 && !visited[i][j + 1] && grid[i][j + 1] != 0) {
                queue
    }
}