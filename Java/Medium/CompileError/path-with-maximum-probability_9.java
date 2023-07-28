class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        // Create a graph with the given edges and probabilities
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], i});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], i});
        }

        // Use Dijkstra's algorithm to find the shortest path
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.add(new int[]{start, 1});

        double[] probs = new double[n];
        probs[start] = 1;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            double prob = node[1];

            if (u == end) {
                return prob;
            }

            if (graph.containsKey(u)) {
                for (int[] v : graph.get(u)) {
                    double newProb = prob * succProb[v[1]];
                    if (probs[v[0]] < newProb) {
                        probs[v[0]] = newProb;
                        pq.add(new int[]{v[0], newProb});
                    }
                }
            }
        }

        return 0;
    }
}