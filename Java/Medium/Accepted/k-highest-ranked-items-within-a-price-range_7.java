class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int low = pricing[0];
        int high = pricing[1];
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) {
                        if (a[2] == b[2]) {
                            return a[3] - b[3];
                        } else {
                            return a[2] - b[2];
                        }
                    } else {
                        return a[1] - b[1];
                    }
                } else {
                    return a[0] - b[0];
                }
            }
        });
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        visited[start[0]][start[1]] = true;
        pq.offer(new int[]{0, grid[start[0]][start[1]], start[0], start[1]});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] >= low && curr[1] <= high) {
                result.add(Arrays.asList(curr[2], curr[3]));
            }
            if (result.size() == k) {
                break;
            }
            for (int[] dir : dirs) {
                int x = curr[2] + dir[0];
                int y = curr[3] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == 0) {
                    continue;
                }
                visited[x][y] = true;
                pq.offer(new int[]{curr[0] + 1, grid[x][y], x, y});
            }
        }
        return result;
    }
}