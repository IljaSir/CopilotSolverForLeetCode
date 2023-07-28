class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = nums[i];
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }
        int res = 0;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int pa = find(parent, a);
            int pb = find(parent, b);
            if (pa == pb) {
                res++;
                continue;
            }
            if (count[pa] > count[pb]) {
                parent[pb] = pa;
                sum[pa] += sum[pb];
                count[pa] += count[pb];
            } else {
                parent[pa] = pb;
                sum[pb] += sum[pa];
                count[pb] += count[pa];
            }
        }
        int root = find(parent, 0);
        for (int i = 0; i < n; i++) {
            if (find(parent, i) == root && sum[i] % count[i] != 0) {
                return -1;
            }
        }
        return res;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}