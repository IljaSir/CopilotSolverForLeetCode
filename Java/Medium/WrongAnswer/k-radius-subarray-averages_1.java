class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(n - 1, i + k);
            int sum = preSum[right];
            if (left > 0) {
                sum -= preSum[left - 1];
            }
            if (right - left + 1 < 2 * k + 1) {
                res[i] = -1;
            } else {
                res[i] = sum / (right - left + 1);
            }
        }
        return res;
    }
}