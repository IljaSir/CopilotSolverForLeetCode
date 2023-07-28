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
            int a = find(edge[0], parent);
            int b = find(edge[1], parent);
            if (a != b) {
                parent[a] = b;
                sum[b] += sum[a];
            }
        }
        int root = find(0, parent);
        if (sum[root] % 3 != 0) {
            return -1;
        }
        int target = sum[root] / 3;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            int p = find(i, parent);
            if (sum[p] == target) {
                count[p]++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] >= 3) {
                res += count[i] - 2;
            }
        }
        return res;
    }
    private int find(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}