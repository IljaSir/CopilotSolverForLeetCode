class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(tree, 0, visited, hasApple);
    }
    
    private int dfs(List<Integer>[] tree, int node, boolean[] visited, List<Boolean> hasApple) {
        visited[node] = true;
        int res = 0;
        for (int next: tree[node]) {
            if (!visited[next]) {
                res += dfs(tree, next, visited, hasApple);
            }
        }
        if (res > 0 || hasApple.get(node)) {
            res += 2;
        }
        return res;
    }
}