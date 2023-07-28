class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int pu = find(parent, u), pv = find(parent, v);
            if (pu != pv) {
                parent[pu] = pv;
            }
        }
        int root = find(parent, 0);
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            xor[find(parent, i)] ^= nums[i];
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (xor[i] > 0 && find(parent, i) == root) {
                min = Math.min(min, xor[i]);
                max = Math.max(max, xor[i]);
            }
        }
        return max - min;
    }
    private int find(int[] parent, int u) {
        if (parent[u] != u) {
            parent[u] = find(parent, parent[u]);
        }
        return parent[u];
    }
}