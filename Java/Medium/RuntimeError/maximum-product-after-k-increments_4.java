class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int res = 1;
        for (int i = 0; i <= k; i++) {
            int left = i;
            int right = k - i;
            if (right > n - 1) {
                continue;
            }
            int min = preSum[left] + (right > 0 ? preSum[n - 1] - preSum[n - 1 - right] : 0);
            int max = preSum[n - 1] - preSum[n - 1 - left] + (right > 0 ? preSum[right - 1] : 0);
            res = Math.max(res, max - min);
        }
        return res;
    }
}