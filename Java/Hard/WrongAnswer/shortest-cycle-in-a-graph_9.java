class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        List<Integer>[] graph = new List[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCycle = Math.min(minCycle, dfs(i, i, graph, path, new HashSet<>()));
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
    
    private int dfs(int start, int end, List<Integer>[] graph, int[] path, Set<Integer> visited) {
        if (visited.contains(end)) {
            if (end == start) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < path[end]; i++) {
                    min = Math.min(min, graph[path[i]].size());
                }
                return path[end] + min;
            }
            return Integer.MAX_VALUE;
        }
        visited.add(end);
        path[end] = start;
        int min = Integer.MAX_VALUE;
        for (int nei : graph[end]) {
            min = Math.min(min, dfs(start, nei, graph, path, visited));
        }
        visited.remove(end);
        return min;
    }
}