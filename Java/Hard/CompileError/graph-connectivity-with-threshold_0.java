class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                union(parent, i, j);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(find(parent, query[0]) == find(parent, query[1]));
        }
        return ans;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}