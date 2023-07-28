class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], i});
            graph.get(edge[1]).add(new int[]{edge[0], i});
        }
        double[] prob = new double[n];
        prob[start] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new int[]{start, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            double p = cur[1];
            if (prob[node] > p) {
                continue;
            }
            if (node == end) {
                return p;
            }
            if (!graph.containsKey(node)) {
                continue;
            }
            for (int[] next : graph.get(node)) {
                int nei = next[0];
                int idx = next[1];
                if (prob[nei] < p * succProb[idx]) {
                    prob[nei] = p * succProb[idx];
                    pq.offer(new int[]{nei, prob[nei]});
                }
            }
        }
        return 0;
    }
}