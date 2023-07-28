class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length, n = mat[0].length;
        int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        int target = 0;
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start |= mat[i][j] << (i * n + j);
                target |= 0 << (i * n + j);
            }
        }
        q.offer(start);
        seen.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == target) return step;
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next = cur;
                        for (int[] dir : dirs) {
                            int x = j + dir[0], y = k + dir[1];
                            if (x < 0 || x >= m || y < 0 || y >= n) continue;
                            next ^= 1 << (x * n + y);
                        }
                        if (!seen.contains(next)) {
                            q.offer(next);
                            seen.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}