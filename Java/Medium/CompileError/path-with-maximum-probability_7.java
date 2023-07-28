class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        // Build the graph
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new int[]{edges[i][1], i});
            graph[edges[i][1]].add(new int[]{edges[i][0], i});
        }
        // Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new int[]{start, 1.0});
        double[] prob = new double[n];
        prob[start] = 1.0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int u = p[0];
            double w = p[1];
            if (u == end) {
                return w;
            }
            for (int[] v : graph[u]) {
                int next = v[0];
                double nextProb = w * succProb[v[1]];
                if (nextProb > prob[next]) {
                    prob[next] = nextProb;
                    pq.offer(new int[]{next, nextProb});
                }
            }
        }
        return 0.0;
    }
}