class Solution {
    public int minChanges(int[] nums, int k) {
        
        int n = nums.length;
        int[] f = new int[1 << 10];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < k; i++) {
            int cnt = 0, max = 0, sum = 0;
            int[] g = new int[1 << 10];
            Arrays.fill(g, n);
            int[] cnts = new int[1 << 10];
            for (int j = i; j < n; j += k) {
                cnt++;
                cnts[nums[j]]++;
                max = Math.max(max, cnts[nums[j]]);
            }
            for (int mask = 0; mask < (1 << 10); mask++) {
                g[mask] = Math.min(g[mask], f[mask] + cnt - max);
                for (int j = i; j < n; j += k) {
                    g[mask ^ nums[j]] = Math.min(g[mask ^ nums[j]], f[mask] + cnt - cnts[nums[j]]);
                }
            }
            f = g;
        }
        return f[0];
    }
}