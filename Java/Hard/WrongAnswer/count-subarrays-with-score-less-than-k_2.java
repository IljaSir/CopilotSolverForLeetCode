class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long ans = 0;
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int left = i, right = n;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (sum[mid + 1] - sum[i] < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            ans += left - i;
        }
        return ans;
    }
}