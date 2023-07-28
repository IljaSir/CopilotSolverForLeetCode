class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        int[] degree = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> edge : edges) {
            degree[edge.get(0)]++;
            degree[edge.get(1)]++;
            if (!map.containsKey(edge.get(0))) {
                map.put(edge.get(0), new ArrayList<>());
            }
            if (!map.containsKey(edge.get(1))) {
                map.put(edge.get(1), new ArrayList<>());
            }
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }
        int odd = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0) {
            return true;
        }
        if (odd % 2 == 1) {
            return false;
        }
        int[] visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1 && visited[i] == 0) {
                if (!dfs(map, visited, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int node, int color) {
        visited[node] = color;
        if (map.containsKey(node)) {
            for (int next : map.get(node)) {
                if (visited[next] == color) {
                    return false;
                }
                if (visited[next] == 0 && !dfs(map, visited, next, -color)) {
                    return false;
                }
            }
        }
        return true;
    }
}