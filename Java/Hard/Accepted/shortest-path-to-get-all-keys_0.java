class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] start = new int[3];
        int totalKeys = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    start[0] = i;
                    start[1] = j;
                    start[2] = 0;
                }
                if (c >= 'a' && c <= 'f') {
                    totalKeys++;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start[0] + " " + start[1] + " " + start[2]);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[2] == (1 << totalKeys) - 1) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    int keys = cur[2];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        char c = grid[x].charAt(y);
                        if (c != '#') {
                            if (c >= 'a' && c <= 'f') {
                                keys |= 1 << (c - 'a');
                            }
                            if (c >= 'A' && c <= 'F' && (keys & (1 << (c - 'A'))) == 0) {
                                continue;
                            }
                            if (!visited.contains(x + " " + y + " " + keys)) {
                                queue.offer(new int[]{x, y, keys});
                                visited.add(x + " " + y + " " + keys);
                            }
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}