class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int[] parents = new int[edges.length + 1];
        int[] cand1 = null;
        int[] cand2 = null;
        for (int[] edge : edges) {
            if (parents[edge[1]] == 0) {
                parents[edge[1]] = edge[0];
            } else {
                cand1 = new int[] {parents[edge[1]], edge[1]};
                cand2 = new int[] {edge[0], edge[1]};
                edge[1] = 0;
            }
        }
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            int root1 = find(edge[0], parents);
            int root2 = find(edge[1], parents);
            if (root1 == root2) {
                if (cand1 == null) {
                    return edge;
                }
                return cand1;
            }
            parents[root2] = root1;
        }
        return cand2;
    }
    private int find(int x, int[] parents) {
        if (x != parents[x]) {
            parents[x] = find(parents[x], parents);
        }
        return parents[x];
    }
}