class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        if (n < 3) return true;
        if (edges.size() < n - 1) return false;
        if (edges.size() == n - 1) {
            return true;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (List<Integer> edge: edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            degree[i] = graph.get(i).size();
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next: graph.get(cur)) {
                    degree[next]--;
                    if (degree[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        return count == n;
    }
}