class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int rootX = findRoot(parent, x);
            int rootY = findRoot(parent, y);
            if (rootX == rootY) {
                continue;
            }
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
        int[] sum = new int[n];
        int[] count = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int root = findRoot(parent, i);
            sum[root] += nums[i];
            count[root]++;
        }
        for (int i = 0; i < n; i++) {
            if (sum[i] % count[i] != 0) {
                return -1;
            }
            int target = sum[i] / count[i];
            if (nums[i] != target) {
                res++;
            }
        }
        return res;
    }

    private int findRoot(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findRoot(parent, parent[x]);
        }
        return parent[x];
    }
}