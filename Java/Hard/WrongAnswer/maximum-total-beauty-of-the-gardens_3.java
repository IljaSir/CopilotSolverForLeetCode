class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        int n = flowers.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (flowers[i] >= target) {
                ++cnt[flowers[i] - target];
            }
        }
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + cnt[i];
        }
        long ans = 0;
        for (int i = 0; i <= n; ++i) {
            long left = newFlowers - (sum[n] - sum[i]);
            if (left < 0) {
                break;
            }
            long cur = (sum[i] + Math.min(left, (long) (n - i) * target)) * full;
            if (i < n) {
                cur += Math.min(left, (long) (n - i) * target) * partial;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}