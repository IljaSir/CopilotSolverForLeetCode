class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        int[] color = new int[n];
        for(int i = 0; i < n; i++) {
            if(dfs(graph, i, color)) {
                ans.add(i);
            }
        }
        return ans;
    }
    
    private boolean dfs(int[][] graph, int node, int[] color) {
        if(color[node] > 0) {
            return color[node] == 2;
        }
        color[node] = 1;
        for(int next : graph[node]) {
            if(color[next] == 2) {
                continue;
            }
            if(color[next] == 1 || !dfs(graph, next, color)) {
                return false;
            }
        }
        color[node] = 2;
        return true;
    }
}