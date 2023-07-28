class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        int n = flowers.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + flowers[i - 1];
        }
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            int l = i, r = n;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (sum[mid] - sum[i] >= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            long cur = (long) (l - i) * full + (sum[n] - sum[l]) * partial;
            if (l < n) {
                cur += Math.min(newFlowers, (long) (target - (sum[l + 1] - sum[i])) * (l - i + 1));
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}