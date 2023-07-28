class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
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
}