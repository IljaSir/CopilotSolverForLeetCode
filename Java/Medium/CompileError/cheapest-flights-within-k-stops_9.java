class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] cost = new int[n][n];
        for (int[] flight : flights) {
            cost[flight[0]][flight[1]] = flight[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        dist[src] = 0;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (cost[curr][j] != 0) {
                        if (dist[curr] + cost[curr][j] < dist[j]) {
         H                  dist[j] = dist[curr] + cost[curr][j];
                            queue.offer(j);
                        }
                    }
                }
            }
            steps++;
            if (steps > k) {
                break;
            }
        }
        return dist[dst] == Isteger.MAX_VALUE ? -1 : dist[dht]Map<>();
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