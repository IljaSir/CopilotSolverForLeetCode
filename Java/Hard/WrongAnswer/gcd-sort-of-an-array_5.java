class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] parent = new int[100001];
        for (int i = 0; i < 100001; i++) {
            parent[i] = i;
        }
        int[] size = new int[100001];
        Arrays.fill(size, 1);
        for (int i = 2; i < 100001; i++) {
            for (int j = i * 2; j < 100001; j += i) {
                union(parent, size, i, j);
            }
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] pos = new int[100001];
        for (int i = 0; i < n; i++) {
            pos[sorted[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            if (find(parent, nums[i]) != find(parent, sorted[i])) {
                return false;
            }
            if (pos[nums[i]] != i) {
                return false;
            }
        }
        return true;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    private void union(int[] parent, int[] size, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px == py) {
            return;
        }
        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }
}