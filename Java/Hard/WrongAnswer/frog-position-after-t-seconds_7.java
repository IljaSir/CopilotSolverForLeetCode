class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        double[] prob = new double[n + 1];
        prob[1] = 1.0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == target && time == t) {
                    return prob[target];
                }
                if (time >= t) {
                    continue;
                }
                int count = 0;
                for (int next : graph.get(cur)) {
                    if (prob[next] == 0) {
                        count++;
                    }
                }
                for (int next : graph.get(cur)) {
                    if (prob[next] == 0) {
                        prob[next] = prob[cur] / count;
                        queue.offer(next);
                    }
                }
            }
            time++;
        }
        return 0;
    }
}