class Solution {
    public int minFlips(int[][] mat) {
        
        int M = mat.length;
        int N = mat[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                start |= mat[i][j] << (i * N + j);
            }
        }
        queue.offer(start);
        seen.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == 0) {
                    return steps;
                }
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < N; k++) {
                        int next = cur;
                        for (int[] dir : dirs) {
                            int x = j + dir[0];
                            int y = k + dir[1];
                            if (x >= 0 && x < M && y >= 0 && y < N) {
                                next ^= 1 << (x * N + y);
                            }
                        }
                        if (!seen.contains(next)) {
                            queue.offer(next);
                            seen.add(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}