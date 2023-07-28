class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        int[] conflict = new int[]{-1, -1};
        int[] cycle = new int[]{-1, -1};
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != v) {
                conflict = new int[]{u, v};
            } else {
                parent[v] = u;
                int pu = find(parent, u);
                if (pu == v)
                    cycle = new int[]{u, v};
            }
        }
        if (conflict[0] == -1)
            return cycle;
        else {
            if (cycle[0] == -1)
                return conflict;
            else {
                for (int[] edge : edges) {
                    if (edge[1] == conflict[1])
                        return edge;
                }
                return new int[]{};
            }
        }
    }
}