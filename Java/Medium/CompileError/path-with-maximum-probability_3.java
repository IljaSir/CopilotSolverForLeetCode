class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], i});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], i});
        }
        double[] probs = new double[n];
        probs[start] = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        queue.add(new int[]{start, 1});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int u = node[0];
            double prob = node[1];
            if (u == end) {
                return prob;
            }
            if (prob <= probs[u]) {
                continue;
            }
            for (int[] v : graph.getOrDefault(u, Collections.emptyList())) {
                int index = v[1];
                double newProb = prob * succProb[index];
                if (newProb > probs[v[0]]) {
                    probs[v[0]] = newProb;
                    queue.add(new int[]{v[0], newProb});
                }
            }
        }
        return 0;
    }
}