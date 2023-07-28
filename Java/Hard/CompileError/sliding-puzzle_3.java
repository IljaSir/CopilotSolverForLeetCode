class Solution {
    public int slidingPuzzle(int[][] board) {
        
        int[][] dirs = new int[][] {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        String start = sb.toString();
        if (start.equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                int idx = cur.indexOf('0');
                for (int dir : dirs[idx]) {
                    String next = swap(cur, idx, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(target)) {
                        return step;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return -1;
    }
}