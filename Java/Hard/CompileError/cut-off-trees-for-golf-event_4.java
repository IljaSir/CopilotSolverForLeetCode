class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = forest.get(i).get(j);
            }
        }
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 1) {
                    pq.offer(new int[] {i, j, grid[i][j]});
                }
            }
        }
        int[] start = new int[] {0, 0};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int dist = distance(grid, start, tree, m, n, dirs);
            if (dist == -1) {
                return -1;
            }
            res += dist;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return res;
    }
    
    private int distance(int[][] grid, int[] start, int[] tree, int m, int n, int[][] dirs) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == tree[0] && cur[1] == tree[1]) {
                    return dist;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] +
    }
}