class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0] - 1).add(e[1] - 1);
            graph.get(e[1] - 1).add(e[0] - 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0], d = cur[1];
            if (d > dist[v]) {
                continue;
            }
            for (int nei : graph.get(v)) {
                int t = d + time;
                t += (t / change) % 2 == 1 ? change - t % change : 0;
                if (t < dist[nei]) {
                    dist[nei] = t;
                    pq.offer(new int[]{nei, t});
                }
            }
        }
        return dist[n - 1];
    }
}