class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int res = 0;
        for (int i = firstLen; i <= n; i++) {
            int first = preSum[i] - preSum[i - firstLen];
            res = Math.max(res, first + Math.max(preSum[i - firstLen + secondLen] - preSum[i - firstLen], preSum[n] - preSum[i]));
        }
        for (int i = secondLen; i <= n; i++) {
            int second = preSum[i] - preSum[i - secondLen];
            res = Math.max(res, second + Math.max(preSum[i - secondLen + firstLen] - preSum[i - secondLen], preSum[n] - preSum[i]));
        }
        return res;
    }
}