class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        if (blocked.length == 0) {
            return true;
        }
        Set<String> blockSet = new HashSet<>();
        for (int[] block : blocked) {
            blockSet.add(block[0] + "," + block[1]);
        }
        return bfs(blockSet, source, target) && bfs(blockSet, target, source);
    }
    private boolean bfs(Set<String> blockSet, int[] source, int[] target) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        Set<String> visited = new HashSet<>();
        visited.add(source[0] + "," + source[1]);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == target[0] && cur[1] == target[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                String key = x + "," + y;
                if (x < 0 || x >= 1000000 || y < 0 || y >= 1000000 || blockSet.contains(key) || visited.contains(key)) {
                    continue;
                }
                queue.offer(new int[]{x, y});
                visited.add(key);
            }
        }
        return false;
    }
}