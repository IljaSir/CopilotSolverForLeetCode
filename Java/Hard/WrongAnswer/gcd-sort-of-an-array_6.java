class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] parent = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            parent[i] = i;
        }
        for (int i = 2; i <= 100000; i++) {
            for (int j = 2 * i; j <= 100000; j += i) {
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

    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }
}