class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        
        int N = patience.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, 100000);
        dist[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nei : graph.get(node)) {
                if (dist[nei] > dist[node] + 1) {
                    dist[nei] = dist[node] + 1;
                    queue.offer(nei);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < N; i++) {
            int d = dist[i];
            int p = patience[i];
            int r = d % p;
            if (r == 0) {
                ans = Math.max(ans, d * 2);
            } else {
                ans = Math.max(ans, d + (p - r));
            }
        }
        return ans;
    }
}