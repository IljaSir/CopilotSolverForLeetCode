class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            q.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int u = info[0], mask = info[1], dist = info[2];
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }

            // Try to walk to every neighbor of node u
            for (int v: graph[u]) {
                // vMask = mask w/ vth bit set to 1
                int vMask = mask | (1 << v);
                if (!seen[v][vMask]) {
                    q.offer(new int[]{v, vMask, dist + 1});
                    seen[v][vMask] = true;
                }
            }
        }

        return ans;
    }
}