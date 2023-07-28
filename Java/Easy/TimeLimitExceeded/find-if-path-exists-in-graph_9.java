class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        // create graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        // bfs
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return true;
            }
            visited.add(node);
            for (int neighbor: graph[node]) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
}