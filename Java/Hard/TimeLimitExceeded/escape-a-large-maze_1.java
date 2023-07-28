class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        Set<String> block = new HashSet<>();
        for (int[] b : blocked) {
            block.add(b[0] + "," + b[1]);
        }
        return bfs(block, source[0], source[1], target[0], target[1]) && bfs(block, target[0], target[1], source[0], source[1]);
    }
    private boolean bfs(Set<String> block, int sx, int sy, int tx, int ty) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        Set<String> visited = new HashSet<>();
        visited.add(sx + "," + sy);
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == tx && cur[1] == ty) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= 1e6 || y < 0 || y >= 1e6 || visited.contains(x + "," + y) || block.contains(x + "," + y)) {
                    continue;
                }
                q.offer(new int[]{x, y});
                visited.add(x + "," + y);
            }
        }
        return false;
    }
}