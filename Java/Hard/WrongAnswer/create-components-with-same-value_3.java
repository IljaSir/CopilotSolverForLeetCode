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
        int count = n;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            int px = find(parent, x), py = find(parent, y);
            if (px != py) {
                parent[px] = py;
                sum[py] += sum[px];
                count--;
            }
        }
        int maxValue = 0;
        for (int s : sum) {
            maxValue = Math.max(maxValue, s);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] == maxValue) {
                ans++;
            }
        }
        return count - ans;
    }
    int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}