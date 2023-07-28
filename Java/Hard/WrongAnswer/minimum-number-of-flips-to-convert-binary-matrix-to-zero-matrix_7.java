class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length, n = mat[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        int start = 0, step = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start |= mat[i][j] << (i * n + j);
            }
        }
        if (start == 0) {
            return 0;
        }
        q.offer(start);
        seen.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int tmp = cur;
                        for (int[] dir : dirs) {
                            int x = j + dir[0], y = k + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                tmp ^= 1 << (x * n + y);
                            }
                        }
                        if (tmp == 0) {
                            return step + 1;
                        }
                        if (!seen.contains(tmp)) {
                            q.offer(tmp);
                            seen.add(tmp);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}