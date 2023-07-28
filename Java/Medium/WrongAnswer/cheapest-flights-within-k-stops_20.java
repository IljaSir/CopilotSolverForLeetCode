class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, k + 1}); // {cost, node, stops}
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[1], stops = top[2], c = top[0];
            if (u == dst) return c;
            if (stops > 0) {
                for (int[] v : graph.getOrDefault(u, new ArrayList<>())) {
                    if (c + v[1] < cost[v[0]]) {
                        cost[v[0]] = c + v[1];
                        pq.offer(new int[]{cost[v[0]], v[0], stops - 1});
                    }
                }
            }
        }
        return -1;
    }
}