class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] color = new int[n];
        int[] parent = new int[n];
        int[] length = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                res = Math.max(res, dfs(edges, i, color, parent, length));
            }
        }
        return res;
    }
    private int dfs(int[] edges, int i, int[] color, int[] parent, int[] length) {
        color[i] = 1;
        int res = 0;
        if (edges[i] != -1) {
            if (color[edges[i]] == 0) {
                parent[edges[i]] = i;
                res = dfs(edges, edges[i], color, parent, length);
            } else if (color[edges[i]] == 1) {
                int cur = i;
                int l = 0;
                while (cur != edges[i]) {
                    l++;
                    cur = parent[cur];
                }
                l++;
                res = l;
            }
        }
        color[i] = 2;
        length[i] = res;
        return res;
    }
}