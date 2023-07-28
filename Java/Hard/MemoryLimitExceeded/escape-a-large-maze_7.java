class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        if (blocked.length == 0) {
            return true;
        }
        int[][] graph = new int[1000000][1000000];
        for (int[] b : blocked) {
            graph[b[0]][b[1]] = -1;
        }
        return bfs(graph, source, target) && bfs(graph, target, source);
    }

    public boolean bfs(int[][] graph, int[] source, int[] target) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        Set<String> visited = new HashSet<>();
        visited.add(source[0] + "," + source[1]);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == target[0] && curr[1] == target[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x >= 0 && x < 1000000 && y >= 0 && y < 1000000 && graph[x][y] != -1 && !visited.contains(x + "," + y)) {
                    queue.offer(new int[]{x, y});
                    visited.add(x + "," + y);
                }
            }
        }
        return false;
    }
}