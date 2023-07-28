class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new int[]{edges[i][1], i});
            graph[edges[i][1]].add(new int[]{edges[i][0], i});
        }
        double[] prob = new double[n];
        prob[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] edge : graph[node]) {
                int next = edge[0], idx = edge[1];
                if (prob[next] < prob[node] * succProb[idx]) {
                    prob[next] = prob[node] * succProb[idx];
                    queue.add(next);
                }
            }
        }
        return prob[end];
    }
}