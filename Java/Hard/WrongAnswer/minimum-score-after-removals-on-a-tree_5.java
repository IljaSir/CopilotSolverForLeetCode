class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int rx = find(root, x);
            int ry = find(root, y);
            if (rx != ry) {
                root[rx] = ry;
            }
        }
        int[] cnt = new int[n];
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            int r = find(root, i);
            cnt[r]++;
            xor[r] ^= nums[i];
        }
        int res = Integer.MAX_VALUE;
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int rx = find(root, x);
            int ry = find(root, y);
            if (rx == ry) {
                continue;
            }
            int c1 = cnt[rx];
            int c2 = cnt[ry];
            int x1 = xor[rx];
            int x2 = xor[ry];
            res = Math.min(res, (c1 * x2 ^ c2 * x1) - (c1 * c2 * (x1 ^ x2)));
        }
        return res;
    }
    int find(int[] root, int x) {
        if (root[x] != x) {
            root[x] = find(root, root[x]);
        }
        return root[x];
    }
}