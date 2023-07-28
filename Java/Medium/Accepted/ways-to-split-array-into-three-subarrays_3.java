class Solution {
    public int waysToSplit(int[] nums) {
        
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 1; i <= n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (preSum[mid] - preSum[i] >= preSum[i]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            int left = l;
            l = i + 1;
            r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (preSum[n] - preSum[mid] >= preSum[mid] - preSum[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int right = r;
            if (left <= right) {
                res += right - left + 1;
                res %= 1000000007;
            }
        }
        return res;
    }
}