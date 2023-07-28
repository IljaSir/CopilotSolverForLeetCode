class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int total = 1 << (m * n);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start = start * 2 + mat[i][j];
            }
        }
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == 0) {
                    return step;
                }
                for (int j = 0; j < total; j++) {
                    int next = cur;
                    for (int[] dir : dirs) {
                        int x = j / n + dir[0];
                        int y = j % n + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            next ^= (1 << (x * n + y));
                        }
                    }
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}