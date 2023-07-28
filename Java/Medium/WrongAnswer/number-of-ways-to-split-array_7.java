class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        long ans = 0;
        for (int i = 0; i < n - 2; ++i) {
            long left = preSum[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (preSum[mid] - left >= left) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (l == n - 1) {
                break;
            }
            int right = l + 1;
            l = i + 1;
            r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (preSum[n - 1] - preSum[mid] >= preSum[mid] - left) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans += Math.max(0, Math.min(right, r) - l + 1);
        }
        return (int) (ans % 1000000007);
    }
}