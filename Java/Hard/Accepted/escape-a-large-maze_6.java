class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        if (blocked.length == 0) {
            return true;
        }
        Set<String> blockedSet = new HashSet<>();
        for (int[] block: blocked) {
            blockedSet.add(block[0] + "-" + block[1]);
        }
        return bfs(blockedSet, source, target) && bfs(blockedSet, target, source);
    }
    private boolean bfs(Set<String> blockedSet, int[] source, int[] target) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        Set<String> visited = new HashSet<>();
        visited.add(source[0] + "-" + source[1]);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == target[0] && cur[1] == target[1]) {
                return true;
            }
            for (int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= 1_000_000 || y < 0 || y >= 1_000_000 || visited.contains(x + "-" + y) || blockedSet.contains(x + "-" + y)) {
                    continue;
                }
                visited.add(x + "-" + y);
                queue.offer(new int[]{x, y});
                if (visited.size() >= 20000) {
                    return true;
                }
            }
        }
        return false;
    }
}