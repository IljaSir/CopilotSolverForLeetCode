class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] indegree = new int[n];
        for (int[] e : edges) {
            indegree[e[0]]++;
            indegree[e[1]]++;
        }
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                root = i;
                break;
            }
        }
        
        boolean[] visited = new boolean[n];
        dfs(graph, visited, root);
        
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = -1;
        }
        for (int[] e : edges) {
            if (visited[e[0]]) {
                parents[e[1]] = e[0];
            } else {
                parents[e[0]] = e[1];
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                continue;
            }
            int count = 0;
            for (int[] g : guesses) {
                if (g[0] == i && parents[g[1]] == i) {
                    count++;
                }
            }
            if (count == k) {
                res++;
            }
        }
        
        return res;
    }
    
    private void dfs(List<Integer>[] graph, boolean[] visited, int root) {
        if (visited[root]) {
            return;
        }
        visited[root] = true;
        for (int next : graph[root]) {
            dfs(graph, visited, next);
        }
    }
}