class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return dfs(map, visited, source, destination);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, int source, int destination) {
        if (source == destination) return true;
        if (visited[source]) return false;
        visited[source] = true;
        if (map.containsKey(source)) {
            for (int next : map.get(source)) {
                if (dfs(map, visited, next, destination)) return true;
            }
        }
        return false;
    }
}