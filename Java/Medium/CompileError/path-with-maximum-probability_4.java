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
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[1]));
        pq.offer(new int[]{start, 1});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            double currProb = curr[1];
            if (probs[currNode] > currProb) {
                continue;
            }
            for (int[] next : graph.getOrDefault(currNode, Collections.emptyList())) {
                double nextProb = currProb * succProb[next[1]];
                if (probs[next[0]] < nextProb) {
                    probs[next[0]] = nextProb;
                    pq.offer(new int[]{next[0], nextProb});
                }
            }
        }
        return probs[end];
    }
}