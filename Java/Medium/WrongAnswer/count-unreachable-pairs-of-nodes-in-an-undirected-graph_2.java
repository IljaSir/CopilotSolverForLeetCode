class Solution {
    public long countPairs(int n, int[][] edges) {
        
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int[] sizes = new int[n];
        Arrays.fill(sizes, 1);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            union(parents, sizes, from, to);
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) (n - sizes[find(parents, i)] - 1);
        }
        return result / 2;
    }
    private int find(int[] parents, int i) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents, parents[i]);
    }
    private void union(int[] parents, int[] sizes, int i, int j) {
        int pi = find(parents, i);
        int pj = find(parents, j);
        if (pi == pj) {
            return;
        }
        if (sizes[pi] < sizes[pj]) {
            int tmp = pi;
            pi = pj;
            pj = tmp;
        }
        sizes[pi] += sizes[pj];
        parents[pj] = pi;
    }
}