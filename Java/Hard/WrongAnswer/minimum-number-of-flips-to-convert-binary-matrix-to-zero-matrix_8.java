class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start = start * 2 + mat[i][j];
            }
        }
        if (start == 0) {
            return 0;
        }
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next = cur;
                        for (int[] d : dir) {
                            int x = j + d[0];
                            int y = k + d[1];
                            if (x < 0 || x >= m || y < 0 || y >= n) {
                                continue;
                            }
                            next ^= 1 << (m * n - (x * n + y) - 1);
                        }
                        if (next == 0) {
                            return step;
                        }
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}