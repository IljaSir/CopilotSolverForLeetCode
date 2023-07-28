class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n];
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                res[i] = nums[i];
            }
            return res;
        }
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int left = Math.max(i - k, 0);
            int right = Math.min(i + k, n - 1);
            int count = right - left + 1;
            if (count < 2 * k + 1) {
                res[i] = -1;
            } else {
                res[i] = (preSum[right + 1] - preSum[left]) / count;
            }
        }
        return res;
    }
}