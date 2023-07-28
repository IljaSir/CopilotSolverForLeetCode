class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        int[] degree = new int[n];
        int[] visited = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (List<Integer> edge : edges) {
            map.get(edge.get(0) - 1).add(edge.get(1) - 1);
            map.get(edge.get(1) - 1).add(edge.get(0) - 1);
            degree[edge.get(0) - 1]++;
            degree[edge.get(1) - 1]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] % 2 == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur]++;
            if (visited[cur] > 2) {
                return false;
            }
            for (int next : map.get(cur)) {
                degree[next]--;
                if (degree[next] % 2 == 1) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}