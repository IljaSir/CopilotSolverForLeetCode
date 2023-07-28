class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        // 1. Build graph
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, p);
            graph.get(b).put(a, p);
        }
        
        // 2. Dijkstra
        double[] prob = new double[n];
        prob[start] = 1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new int[]{start, 1});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            double p = cur[1];
            if (p < prob[node]) continue;
            
            Map<Integer, Double> neighbors = graph.get(node);
            if (neighbors == null) continue;
            for (int neighbor : neighbors.keySet()) {
                double newP = p * neighbors.get(neighbor);
                if (newP > prob[neighbor]) {
                    prob[neighbor] = newP;
                    pq.offer(new int[]{neighbor, newP});
                }
            }
        }
        
        return prob[end];
    }
}