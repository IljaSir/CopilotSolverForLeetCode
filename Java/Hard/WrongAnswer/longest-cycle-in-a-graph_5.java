class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] visited = new int[n];
        int[] cycle = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (dfs(edges, visited, cycle, i, i, 0) == 1) {
                    max = Math.max(max, cycle[i]);
                }
            }
        }
        return max;
    }
    
    int dfs(int[] edges, int[] visited, int[] cycle, int start, int cur, int len) {
        if (visited[cur] == 1) {
            if (cur == start) {
                cycle[cur] = len;
                return 1;
            }
            return 0;
        }
        visited[cur] = 1;
        if (edges[cur] == -1) {
            return 0;
        }
        if (dfs(edges, visited, cycle, start, edges[cur], len + 1) == 1) {
            cycle[cur] = cycle[edges[cur]] + 1;
            return 1;
        }
        return 0;
    }
}