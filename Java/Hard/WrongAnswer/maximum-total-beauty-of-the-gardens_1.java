class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        int n = flowers.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + flowers[i];
        }
        long[] suffix = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            suffix[i] = suffix[i + 1] + flowers[i];
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            long x = prefix[i + 1];
            if (x >= target) {
                ans = Math.max(ans, (x - target) / target * full + x % target * partial);
            }
            if (x < target && newFlowers >= target - x) {
                ans = Math.max(ans, (x + newFlowers - target) / target * full + x % target * partial);
            }
        }
        for (int i = 0; i < n; ++i) {
            long x = suffix[i];
            if (x >= target) {
                ans = Math.max(ans, (x - target) / target * full + x % target * partial);
            }
            if (x < target && newFlowers >= target - x) {
                ans = Math.max(ans, (x + newFlowers - target) / target * full + x % target * partial);
            }
        }
        return ans;
    }
}