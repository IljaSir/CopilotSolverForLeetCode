class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        if (blocked.length == 0) return true;
        Set<String> blockSet = new HashSet<>();
        for (int[] block : blocked) {
            blockSet.add(block[0] + "," + block[1]);
        }
        return bfs(blockSet, source, target) && bfs(blockSet, target, source);
    }
    
    private boolean bfs(Set<String> blockSet, int[] source, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<String> visited = new HashSet<>();
        visited.add(source[0] + "," + source[1]);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx >= 0 && nx < 1e6 && ny >= 0 && ny < 1e6 && !visited.contains(nx + "," + ny) && !blockSet.contains(nx + "," + ny)) {
                    if (nx == target[0] && ny == target[1]) return true;
                    queue.offer(new int[]{nx, ny});
                    visited.add(nx + "," + ny);
                    if (visited.size() > 20000) return true;
                }
            }
        }
        return false;
    }
}