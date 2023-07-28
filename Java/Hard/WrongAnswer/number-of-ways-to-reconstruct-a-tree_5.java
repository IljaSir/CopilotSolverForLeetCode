class Solution {
    public int checkWays(int[][] pairs) {
        
        int n = 501;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] pair : pairs) {
            int p1 = find(parent, pair[0]);
            int p2 = find(parent, pair[1]);
            if (p1 != p2) {
                parent[p1] = p2;
            }
        }
        int[] count = new int[n];
        int[] degree = new int[n];
        for (int i = 1; i < n; i++) {
            count[find(parent, i)]++;
        }
        for (int[] pair : pairs) {
            degree[pair[0]]++;
            degree[pair[1]]++;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (degree[i] == count[i] - 1) {
                res++;
            }
        }
        return res == 0 ? 0 : (res == 1 ? 1 : 2);
    }
    int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}