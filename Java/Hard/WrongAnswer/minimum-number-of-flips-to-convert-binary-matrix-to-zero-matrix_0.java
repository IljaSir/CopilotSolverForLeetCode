class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] visited = new int[(int)Math.pow(2, m*n)];
        Queue<Integer> queue = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start += mat[i][j] << (i*n + j);
            }
        }
        queue.offer(start);
        visited[start] = 1;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == 0) {
                    return step;
                }
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next = cur;
                        for (int[] dir : dirs) {
                            int x = j + dir[0];
                            int y = k + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                next ^= 1 << (x*n + y);
                            }
                        }
                        if (visited[next] == 0) {
                            queue.offer(next);
                            visited[next] = 1;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}