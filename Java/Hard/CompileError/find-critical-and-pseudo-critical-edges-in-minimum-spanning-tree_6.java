class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        result.add(critical);
        result.add(pseudoCritical);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(edges, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        int minWeight = 0;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x != y) {
                union(parent, rank, x, y);
                minWeight += edge[2];
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x != y) {
                union(parent, rank, x, y);
                if (minWeight + edge[2] == minWeight(n, edges, i)) {
                    pseudoCritical.add(edge[3]);
                }
            }
            else {
                if (minWeight == minWeight(n, edges, i)) {
                    critical.add(edge[3]);
                }
            }
        }
        return result;
    }
    public int minWeight(int n, int[][] edges, int exclude) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
        }
        int
    }
}