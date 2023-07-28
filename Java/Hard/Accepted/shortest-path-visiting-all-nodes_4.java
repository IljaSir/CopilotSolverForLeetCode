class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            visited.add(i + "," + (1 << i));
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], mask = curr[1], dist = curr[2];
            if (mask == (1 << n) - 1) {
                res = dist;
                break;
            }
            for (int next : graph[node]) {
                int nextMask = mask | (1 << next);
                if (!visited.contains(next + "," + nextMask)) {
                    queue.offer(new int[]{next, nextMask, dist + 1});
                    visited.add(next + "," + nextMask);
                }
            }
        }
        return res;
    }
}