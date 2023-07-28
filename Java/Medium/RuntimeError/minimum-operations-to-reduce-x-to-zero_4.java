class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int target = x - preSum[i];
            int lo = i;
            int hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (preSum[mid + 1] - preSum[i] >= target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            if (preSum[lo + 1] - preSum[i] == target) {
                ans = Math.min(ans, n - (lo - i + 1));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}