class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (presum[mid + 1] - presum[i + 1] >= lower) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int lo = l;
            l = i + 1;
            r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (presum[mid + 1] - presum[i + 1] <= upper) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int hi = r;
            ans += Math.max(0, hi - lo);
        }
        return ans;
    }
}