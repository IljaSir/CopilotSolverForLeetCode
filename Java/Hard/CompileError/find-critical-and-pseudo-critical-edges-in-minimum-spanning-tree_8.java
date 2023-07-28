class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];
        int[][] edgesWithIndex = new int[edges.length][4];
        for (int i = 0; i < edges.length; i++) {
            edgesWithIndex[i] = new int[] {edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(edgesWithIndex, (a, b) -> a[2] - b[2]);
        int mst = kruskal(parent, rank, edgesWithIndex, -1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int i = 0; i < edgesWithIndex.length; i++) {
            if (mst != kruskal(parent, rank, edgesWithIndex, i)) {
                res.get(0).add(edgesWithIndex[i][3]);
            } else if (mst == kruskal(parent, rank, edgesWithIndex, i, edgesWithIndex[i][3])) {
                res.get(1).add(edgesWithIndex[i][3]);
            }
        }
        return res;
    }
    
    private int kruskal(int[] parent, int[] rank, int[][] edgesWithIndex, int skip) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int res = 0;
        int count = 0;
        for (int i = 0; i < edgesWithIndex.length; i++) {
            if (i == skip) {
                continue;
            }
            int[] edge = edgesWithIndex[i];
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x == y) {
                continue;
            }
            res += edge[2];
            count++;
            if (rank[x] > rank[y]) {
                parent[y] = x;
            } else if (rank[y] > rank[x]) {
                parent[x] = y;
            } else {
                parent[y] = x;
                rank[x]++;
            }
        }
        return count == parent.length
    }
}