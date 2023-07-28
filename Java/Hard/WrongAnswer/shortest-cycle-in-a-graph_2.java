class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int node = queue.poll();
                    if (visited.contains(node)) {
                        min = Math.min(min, level);
                        break;
                    }
                    visited.add(node);
                    for (int neighbor : graph.get(node)) {
                        queue.add(neighbor);
                    }
                }
                level++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}