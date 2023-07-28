class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        int target = (1 << n) - 1;
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i, 0});
            visited.add(i + "-" + (1 << i));
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], mask = cur[1], dist = cur[2];
            if (mask == target) {
                return dist;
            }
            for (int v : graph[u]) {
                int maskV = mask | (1 << v);
                if (!visited.contains(v + "-" + maskV)) {
                    q.offer(new int[]{v, maskV, dist + 1});
                    visited.add(v + "-" + maskV);
                }
            }
        }
        return -1;
    }
}