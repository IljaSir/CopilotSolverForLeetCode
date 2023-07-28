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
        for (int[] edge : edges) {
            int p1 = findParent(parent, edge[0]);
            int p2 = findParent(parent, edge[1]);
            if (p1 != p2) {
                parent[p1] = p2;
                sum[p2] += sum[p1];
            }
        }
        int total = sum[findParent(parent, 0)];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (findParent(parent, i) == i) {
                if (sum[i] == total) {
                    count++;
                }
            }
        }
        return edges.length - count;
    }
    private int findParent(int[] parent, int i) {
        if (i != parent[i]) {
            parent[i] = findParent(parent, parent[i]);
        }
        return parent[i];
    }
}