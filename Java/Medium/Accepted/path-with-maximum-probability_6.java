class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], succProb[i]);
            graph.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], succProb[i]);
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});
        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int curNode = (int) cur[0];
            double curProb = cur[1];
            if (curNode == end) {
                return curProb;
            }
            if (visited[curNode]) {
                continue;
            }
            visited[curNode] = true;
            for (int nextNode : graph.getOrDefault(curNode, new HashMap<>()).keySet()) {
                if (visited[nextNode]) {
                    continue;
                }
                double nextProb = curProb * graph.get(curNode).get(nextNode);
                pq.offer(new double[]{nextNode, nextProb});
            }
        }
        return 0.0;
    }
}