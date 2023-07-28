class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            graph[i].add(favorite[i]);
        }
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            if (dfs(i, graph, match, visited)) {
                result++;
            }
        }
        return result;
    }
    private boolean dfs(int u, List<Integer>[] graph, int[] match, boolean[] visited) {
        for (int v : graph[u]) {
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            if (match[v] == -1 || dfs(match[v], graph, match, visited)) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }
}