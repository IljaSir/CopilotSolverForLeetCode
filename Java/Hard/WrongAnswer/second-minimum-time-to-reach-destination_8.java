class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], d = cur[1];
            if (d >= dist[node]) {
                continue;
            }
            dist[node] = d;
            for (int next : graph.get(node)) {
                int cycle = d / change;
                int remain = d % change;
                int wait = cycle % 2 == 0 ? Math.max(0, change - remain) : remain;
                q.offer(new int[] {next, d + time + wait});
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int d : dist) {
            if (d > dist[0] && d < ans) {
                ans = d;
            }
        }
        return ans;
    }
}