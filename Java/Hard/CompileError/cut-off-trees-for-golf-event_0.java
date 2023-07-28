class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) {
                    trees.add(new int[] {height, i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> a[0] - b[0]);
        int total = 0;
        int[] start = new int[] {0, 0};
        for (int[] tree : trees) {
            int steps = bfs(forest, start[0], start[1], tree[1], tree[2]);
            if (steps == -1) {
                return -1;
            }
            total += steps;
            start[0] = tree[1];
            start[1] = tree[2];
        }
        return total;
    }

    private int bfs(List<List<Integer>> forest, int startRow, int startCol, int endRow, int endCol) {
        int m = forest.size();
        int n = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[] {startRow, startCol});
        visited[startRow][startCol] = true;
        int steps = 0;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == endRow && cur[1] == endCol) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int nextRow = cur[0] + dir[0];
                    int nextCol = cur[1] + dir[1];
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol] && forest.get(nextRow).get(nextCol) > 0
    }
}