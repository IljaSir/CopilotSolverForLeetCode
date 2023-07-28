class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            for (int[] next : graph[node]) {
                if (dist[next[0]] > d + next[1]) {
                    dist[next[0]] = d + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(1, n, graph, dist, memo);
    }
    private int dfs(int node, int n, List<int[]>[] graph, int[] dist, int[] memo) {
        if (node == n) {
            return 1;
        }
        if (memo[node] != -1) {
            return memo[node];
        }
        int res = 0;
        for (int[] next : graph[node]) {
            if (dist[next[0]] > dist[node]) {
                res = (res + dfs(next[0], n, graph, dist, memo)) % 1000000007;
            }
        }
        memo[node] = res;
        return res;
    }
}