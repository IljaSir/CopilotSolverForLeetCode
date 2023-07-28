class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int state = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                state = (state << 1) + mat[i][j];
            }
        }
        if (state == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(state);
        int step = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(state);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur_state = queue.poll();
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next_state = cur_state;
                        for (int[] d : dir) {
                            int x = j + d[0];
                            int y = k + d[1];
                            if (x < 0 || x >= m || y < 0 || y >= n) continue;
                            next_state ^= (1 << (x * n + y));
                        }
                        if (next_state == 0) return step;
                        if (visited.contains(next_state)) continue;
                        queue.offer(next_state);
                        visited.add(next_state);
                    }
                }
            }
        }
        return -1;
    }
}