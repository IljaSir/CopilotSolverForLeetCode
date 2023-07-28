class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            if (a[3] != b[3]) {
                return a[3] - b[3];
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        queue.offer(new int[]{start[0], start[1], 0, grid[start[0]][start[1]]});
        boolean[][] visited = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        while (k > 0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[3] < pricing[0] || cur[3] > pricing[1]) {
                continue;
            }
            if (visited[cur[0]][cur[1]]) {
                continue;
            }
            visited[cur[0]][cur[1]] = true;
            res.add(Arrays.asList(cur[0], cur[1]));
            k--;
            if (cur[0] > 0 && grid[cur[0] - 1][cur[1]] > 0) {
                queue.offer(new int[]{cur[0] - 1, cur[1], cur[2] + 1, grid[cur[0] - 1][cur[1]]});
            }
            if (cur[0] < m - 1 && grid[cur[0] + 1][cur[1]] > 0) {
                queue.offer(new int[]{cur[0] + 1, cur[1], cur[2] + 1, grid[cur[0] + 1][cur[1]]});
            }
            if (cur[1] > 0 && grid[cur[0]][cur[1] - 1] > 0) {
                queue.offer(new int[]{cur[0], cur[1] - 1, cur[2] + 1, grid[cur[0]][cur[1] - 1]});
            }
            if (cur[1] < n - 1 && grid[cur[0
    }
}