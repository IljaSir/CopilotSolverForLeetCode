class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCycle = Math.min(minCycle, bfs(graph, i, n));
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] path = new int[n];
        Arrays.fill(path, -1);
        path[start] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (path[next] == -1) {
                    path[next] = path[cur] + 1;
                    queue.offer(next);
                } else if (next != start && path[next] >= path[cur]) {
                    return path[cur] + path[next] + 1;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}