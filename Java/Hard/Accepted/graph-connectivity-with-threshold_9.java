class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        if (n < 2) {
            return result;
        }
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                union(parent, i, j);
            }
        }
        for (int[] query : queries) {
            result.add(find(parent, query[0]) == find(parent, query[1]));
        }
        return result;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }
}