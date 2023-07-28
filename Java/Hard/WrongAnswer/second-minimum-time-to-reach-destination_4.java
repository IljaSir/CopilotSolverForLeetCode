class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                int timeToNext = dist[cur] + time;
                int cycle = timeToNext / change;
                if (cycle % 2 == 1) {
                    timeToNext = (cycle + 1) * change;
                }
                if (timeToNext < dist[next]) {
                    dist[next] = timeToNext;
                    queue.offer(next);
                }
            }
        }
        return dist[n - 1];
    }
}