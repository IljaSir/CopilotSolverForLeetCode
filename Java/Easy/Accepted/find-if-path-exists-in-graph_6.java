class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        if (source == destination) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> set = map.getOrDefault(edge[0], new HashSet<>());
            set.add(edge[1]);
            map.put(edge[0], set);
            set = map.getOrDefault(edge[1], new HashSet<>());
            set.add(edge[0]);
            map.put(edge[1], set);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (map.get(curr) != null) {
                    for (int next : map.get(curr)) {
                        if (next == destination) return true;
                        if (!visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}