class Solution {
    public int slidingPuzzle(int[][] board) {
        
        int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int v : row) {
                sb.append(v);
            }
        }
        String start = sb.toString();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }
                int zero = cur.indexOf('0');
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}