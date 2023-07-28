class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int v = cur[0], d = cur[1];
            if (d >= dist[v]) {
                continue;
            }
            dist[v] = d;
            for (int u : graph.get(v)) {
                int t = d + time;
                int r = t % (2 * change);
                if (r > change) {
                    t += 2 * change - r;
                }
                queue.add(new int[] {u, t});
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist[i] > dist[0] && dist[i] < ans) {
                ans = dist[i];
            }
        }
        return ans;
    }
}