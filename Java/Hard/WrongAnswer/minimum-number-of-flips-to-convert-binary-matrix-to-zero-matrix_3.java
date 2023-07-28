class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int target = 0;
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    target |= 1 << (i * n + j);
                }
                if ((i + j) % 2 == 0) {
                    start |= 1 << (i * n + j);
                }
            }
        }
        if (target == 0) {
            return 0;
        }
        if (start == target) {
            return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next = current;
                        for (int[] dir : dirs) {
                            int x = j + dir[0];
                            int y = k + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                next ^= 1 << (x * n + y);
                            }
                        }
                        if (next == target) {
                            return step + 1;
                        }
                        if (!visited.contains(next)) {
                            queue.add(next);
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