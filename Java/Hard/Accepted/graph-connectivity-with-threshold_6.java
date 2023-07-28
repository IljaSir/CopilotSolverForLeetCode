class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        int[] parents = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = i + i; j <= n; j += i) {
                union(parents, i, j);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(find(parents, query[0]) == find(parents, query[1]));
        }
        return res;
    }
    private int find(int[] parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }
    private void union(int[] parents, int i, int j) {
        int p1 = find(parents, i);
        int p2 = find(parents, j);
        if (p1 != p2) {
            parents[p1] = p2;
        }
    }
}