class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], i});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], i});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        pq.add(new int[]{100, start});
        double[] probs = new double[n];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (probs[cur[1]] == cur[0] / 100.0) continue;
            probs[cur[1]] = cur[0] / 100.0;
            if (cur[1] == end) return probs[end];
            for (int[] nei : graph.getOrDefault(cur[1], new ArrayList<>())) {
                pq.add(new int[]{(int) (cur[0] * succProb[nei[1]]), nei[0]});
            }
        }
        return 0;
    }
}