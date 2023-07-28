class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] best = new int[n];
        Arrays.fill(best, Integer.MIN_VALUE);
        best[0] = values[0];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], t = cur[1];
            for (int[] e : adj[u]) {
                int v = e[0], w = e[1];
                if (t + w > maxTime) continue;
                if (best[v] < best[u] + values[v]) {
                    best[v] = best[u] + values[v];
                    queue.offer(new int[]{v, t + w});
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (best[i] > res) res = best[i];
        }
        return res;
    }
}