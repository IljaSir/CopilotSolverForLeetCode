class Solution {
    public int minChanges(int[] nums, int k) {
        
        int n = nums.length;
        int[] f = new int[1 << 10];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < k; i++) {
            int cnt = 0, size = 0, min = n;
            int[] g = new int[1 << 10];
            int[] cnts = new int[1 << 10];
            Arrays.fill(g, n);
            for (int j = i; j < n; j += k) {
                cnts[nums[j]]++;
                size++;
            }
            for (int mask = 0; mask < (1 << 10); mask++) {
                g[mask] = Math.min(g[mask], f[mask] + size);
                for (int j = 0; j < 10; j++) {
                    g[mask ^ (1 << j)] = Math.min(g[mask ^ (1 << j)], f[mask] + size - cnts[mask]);
                }
            }
            f = g;
        }
        return f[0];
    }
}