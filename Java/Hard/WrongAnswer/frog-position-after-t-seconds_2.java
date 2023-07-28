class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        return dfs(map, visited, 1, t, target);
    }
    
    private double dfs(Map<Integer, Set<Integer>> map, boolean[] visited, int cur, int t, int target) {
        if (t == 0) {
            return cur == target ? 1 : 0;
        }
        if (map.get(cur).size() == 1) {
            if (map.get(cur).contains(target)) {
                return 1;
            }
            return 0;
        }
        double res = 0;
        for (int next : map.get(cur)) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            res += dfs(map, visited, next, t - 1, target) / (map.get(cur).size() - 1);
            visited[next] = false;
        }
        return res;
    }
}