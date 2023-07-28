class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                if (a[1] != b[1]) return b[1] - a[1];
                if (a[2] != b[2]) return a[2] - b[2];
                return a[3] - b[3];
            }
        });
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[]{0, grid[start[0]][start[1]], start[0], start[1]});
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            if (visited[cur[2]][cur[3]]) continue;
            visited[cur[2]][cur[3]] = true;
            if (cur[1] >= pricing[0] && cur[1] <= pricing[1]) {
                res.add(Arrays.asList(cur[2], cur[3]));
                k--;
            }
            for (int[] dir : dirs) {
                int x = cur[2] + dir[0];
                int y = cur[3] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) continue;
                pq.offer(new int[]{cur[0] + 1, grid[x][y], x, y});
            }
        }
        return res;
    }
}