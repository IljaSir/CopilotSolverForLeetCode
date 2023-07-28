class Solution {
    public int minChanges(int[] nums, int k) {
        
        int n = nums.length;
        int[] f = new int[1 << 10];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < k; ++i) {
            int cnt = 0;
            int size = 0;
            int maxFreq = 0;
            int mask = 0;
            int[] g = new int[1 << 10];
            Arrays.fill(g, n);
            for (int j = i; j < n; j += k) {
                ++cnt;
                size += nums[j];
                mask ^= nums[j];
                maxFreq = Math.max(maxFreq, ++g[nums[j]]);
            }
            int t2 = Math.min(cnt - maxFreq, f[mask] + cnt - size);
            for (int j = 0; j < (1 << 10); ++j) {
                f[j] = Math.min(f[j], g[j ^ mask] + cnt - maxFreq);
            }
            f[mask] = t2;
        }
        return f[0];
    }
}