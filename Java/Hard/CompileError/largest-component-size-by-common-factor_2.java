class Solution {
    public int largestComponentSize(int[] nums) {
        
        int n = nums.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    union(parent, i, j);
                }
            }
        }
        int[] cnt = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            cnt[p]++;
            res = Math.max(res, cnt[p]);
        }
        return res;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
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