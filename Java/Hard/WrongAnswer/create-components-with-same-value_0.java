class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] parent = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sum[i] = nums[i];
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int pu = find(parent, u);
            int pv = find(parent, v);
            if (pu != pv) {
                parent[pu] = pv;
                sum[pv] += sum[pu];
            }
        }
        int root = find(parent, 0);
        if (sum[root] % 2 == 1) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i && sum[i] != sum[root] / 2) {
                res++;
            }
        }
        return res;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}