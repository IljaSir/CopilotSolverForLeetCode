class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add((long)b[0] << 32 | b[1]);
        }
        return bfs(blockedSet, source[0], source[1], target[0], target[1]) && bfs(blockedSet, target[0], target[1], source[0], source[1]);
    }
    
    private boolean bfs(Set<Long> blockedSet, int sx, int sy, int tx, int ty) {
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        queue.offer(new int[]{sx, sy});
        visited.add((long)sx << 32 | sy);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == tx && cur[1] == ty) {
                return true;
            }
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                long key = (long)nx << 32 | ny;
                if (nx < 0 || nx >= 1_000_000 || ny < 0 || ny >= 1_000_000 || blockedSet.contains(key) || visited.contains(key)) {
                    continue;
                }
                queue.offer(new int[]{nx, ny});
                visited.add(key);
                if (visited.size() > 20000) {
                    return true;
                }
            }
        }
        return false;
    }
}