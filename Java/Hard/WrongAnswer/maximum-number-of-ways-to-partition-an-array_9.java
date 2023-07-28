class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int n = nums.length;
        int[] preSum = new int[n];
        int[] sufSum = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                nums[i] = 0;
            }
            preSum[i] = nums[i];
            if (i > 0) {
                preSum[i] += preSum[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            sufSum[i] = nums[i];
            if (i < n - 1) {
                sufSum[i] += sufSum[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            if (preSum[i] == sufSum[i]) {
                cur++;
            }
            if (i > 0 && preSum[i - 1] == sufSum[i]) {
                cur++;
            }
            if (i < n - 1 && preSum[i] == sufSum[i + 1]) {
                cur++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}