class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] parent = new int[100001];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (int i = 2; i < parent.length; i++) {
            for (int j = i + i; j < parent.length; j += i) {
                union(parent, i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            if (find(parent, nums[i]) != find(parent, sorted[i])) {
                return false;
            }
        }
        return true;
    }
    private int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }
}