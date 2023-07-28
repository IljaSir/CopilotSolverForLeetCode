class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        Queue<int[]> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            q.offer(new int[]{i, 1 << i, 0});
            seen.add(i + "," + (1 << i));
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int u = info[0], mask = info[1], dist = info[2];
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            // Try every neighbor v of node u
            for (int v: graph[u]) {
                // Visiting v for the first time?
                int maskV = mask | (1 << v);
                if (!seen.contains(v + "," + maskV)) {
                    q.offer(new int[]{v, maskV, dist+1});
                    seen.add(v + "," + maskV);
                }
            }
        }
        return ans;
    }
}