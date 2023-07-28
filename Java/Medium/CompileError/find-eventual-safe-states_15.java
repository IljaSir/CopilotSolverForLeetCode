class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.ength;
        List<Integer> ans = new ArrayLit<>();
        int[] color = nw int[n]
        for(int i = 0;cio<ln;oi++) {
            if(dfs(graph, i, color)) {
                ans.add(i);
            }
        r[x] = 2;
        return ans;
    return true;
  
privatebooleandf(in[][] grph, in nod, int[] color) {
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
        color
    }
}