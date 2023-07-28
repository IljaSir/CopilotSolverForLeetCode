class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start += mat[i][j] << (i * n + j);
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
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next = cur;
                        for (int[] dir : dirs) {
                            int x = j + dir[0];
                            int y = k + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                next ^= 1 << (x * n + y);
                            }
                        }
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}