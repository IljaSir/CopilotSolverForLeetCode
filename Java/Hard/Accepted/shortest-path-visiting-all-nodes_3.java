class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            q.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        int res = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], mask = cur[1], dist = cur[2];
            if (mask == (1 << n) - 1) {
                res = dist;
                break;
            }
            // go through neighbors of node u
            for (int v : graph[u]) {
                // add node v to mask
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    q.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return res;
    }
}