class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            value[i] = nums[i];
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (find(parent, x) != find(parent, y)) {
                union(parent, size, value, x, y);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                ans += size[i] - 1;
            }
        }
        return ans;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int[] size, int[] value, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                value[rootX] += value[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                value[rootY] += value[rootX];
            }
        }
    }
}