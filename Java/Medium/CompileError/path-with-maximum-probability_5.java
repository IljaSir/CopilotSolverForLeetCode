class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[] {edge[1], i});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[] {edge[0], i});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new int[] {start, 1});
        double[] prob = new double[n];
        prob[start] = 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == end) return cur[1];
            if (prob[cur[0]] > cur[1]) continue;
            for (int[] next : graph.getOrDefault(cur[0], new ArrayList<>())) {
                double newProb = cur[1] * succProb[next[1]];
                if (newProb > prob[next[0]]) {
                    prob[next[0]] = newProb;
                    pq.offer(new int[] {next[0], newProb});
                }
            }
        }
        return 0;
    }
}