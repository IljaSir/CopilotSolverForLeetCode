class Solution {
    public long countPairs(int n, int[][] edges) {
        
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[i] = 1;
        }
        for (int[] edge : edges) {
            int x = find(parents, edge[0]);
            int y = find(parents, edge[1]);
            if (x != y) {
                parents[y] = x;
                counts[x] += counts[y];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                ans += (long) counts[i] * (counts[i] - 1) / 2;
            }
        }
        return ans;
    }
    
    int find(int[] parents, int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents, parents[x]);
    }
}