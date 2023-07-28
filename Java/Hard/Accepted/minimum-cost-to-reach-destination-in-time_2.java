class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
            graph.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { passingFees[0], 0, 0 });
        int[][] cost = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = passingFees[0];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[1];
            int time = cur[2];
            if (node == n - 1) {
                return cur[0];
            }
            for (int[] next : graph.get(node)) {
                int v = next[0];
                int t = next[1];
                if (time + t <= maxTime && cur[0] + passingFees[v] < cost[v][time + t]) {
                    cost[v][time + t] = cur[0] + passingFees[v];
                    pq.offer(new int[] { cost[v][time + t], v, time + t });
                }
            }
        }
        return -1;
    }
}