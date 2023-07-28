class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new int[]{edges[i][2], edges[i][0], edges[i][1], i};
        }
        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        int mstValue = mst(n, edges, -1, -1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            if (mstValue != mst(n, edges, i, -1)) {
                res.get(0).add(edges[i][3]);
            } else if (mstValue == mst(n, edges, -1, i)) {
                res.get(1).add(edges[i][3]);
            }
        }
        return res;
    }
    
    private int mst(int n, int[][] edges, int skip, int use) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int value = 0, count = 0;
        if (use >= 0) {
            value += edges[use][0];
            count++;
            union(parent, edges[use][1], edges[use][2]);
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == skip) {
                continue;
            }
            int u = edges[i][1], v = edges[i][2];
            if (find(parent, u) != find(parent, v)) {
                union(parent, u, v);
                value += edges[i][0];
                count++;
            }
        }
        return count == n - 1 ? value : Integer.MAX_VALUE;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    
    private void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }
}