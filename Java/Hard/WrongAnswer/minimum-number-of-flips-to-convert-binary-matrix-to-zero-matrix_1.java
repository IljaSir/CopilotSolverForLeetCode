class Solution {
    public int minFlips(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                num = num * 2 + mat[i][j];
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        Set<Integer> visited = new HashSet<>();
        visited.add(num);
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
                        int newNum = cur;
                        for (int[] dir : dirs) {
                            int x = j + dir[0];
                            int y = k + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                int index = x * n + y;
                                newNum ^= 1 << index;
                            }
                        }
                        if (!visited.contains(newNum)) {
                            queue.offer(newNum);
                            visited.add(newNum);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}