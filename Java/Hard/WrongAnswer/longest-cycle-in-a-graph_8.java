class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] visited = new int[n];
        int[] parent = new int[n];
        int[] depth = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                int cycle = dfs(edges, i, visited, parent, depth);
                max = Math.max(max, cycle);
            }
        }
        return max;
    }
    
    private int dfs(int[] edges, int i, int[] visited, int[] parent, int[] depth) {
        if(visited[i] == 1) {
            return depth[parent[i]] - depth[i] + 1;
        } else if(visited[i] == 2) {
            return 0;
        }
        visited[i] = 1;
        parent[i] = i;
        depth[i] = 0;
        if(edges[i] != -1) {
            parent[edges[i]] = i;
            depth[edges[i]] = depth[i] + 1;
            int cycle = dfs(edges, edges[i], visited, parent, depth);
            if(cycle > 0) {
                return cycle;
            }
        }
        visited[i] = 2;
        return 0;
    }
}