class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        // 1. construct graph
        // 2. bfs
        // 3. dfs
        // 4. calculate
        // 5. return
        // 1. construct graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new int[]{b, i});
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new int[]{a, i});
        }
        // 2. bfs
        Set<Integer> restrictedSet = new HashSet<>();
        for (int i : restricted) {
            restrictedSet.add(i);
        }
        int[] reach = new int[n];
        int[] maxReach = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        reach[0] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
                int nei = neighbor[0];
                int idx = neighbor[1];
                int[] edge = edges[idx];
                int a = edge[0];
                int b = edge[1];
                int total = edge[2];
                if (reach[nei] == 0) {
                    reach[nei] = 1;
                    queue.offer(nei);
                }
                if (nei == a) {
                    maxReach[nei] = Math.max(maxReach[nei], Math.min(total, maxReach[cur] + reach[cur] - 1));
                } else {
                    maxReach[nei] = Math.max(maxReach[nei], Math.min(total, maxReach[cur] + reach[cur] - 1));
                }
            }
        }
        // 3. dfs
        int[] used = new int[edges.length];
        dfs(graph, edges, 0, reach, maxReach, used);
        // 4. calculate
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (reach[i] > 0) {
                ans++;
            }
        }
        for (int i
    }
}