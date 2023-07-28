class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int res = 0;
        for (int i = firstLen; i <= nums.length - secondLen; i++) {
            int firstSum = prefixSum[i] - prefixSum[i - firstLen];
            int secondSum = prefixSum[nums.length] - prefixSum[nums.length - secondLen];
            res = Math.max(res, firstSum + secondSum);
        }
        for (int i = secondLen; i <= nums.length - firstLen; i++) {
            int firstSum = prefixSum[i] - prefixSum[i - secondLen];
            int secondSum = prefixSum[nums.length] - prefixSum[nums.length - firstLen];
            res = Math.max(res, firstSum + secondSum);
        }
        for (int i = firstLen; i <= nums.length - secondLen; i++) {
            int firstSum = prefixSum[i] - prefixSum[i - firstLen];
            int secondSum = prefixSum[i - firstLen] - prefixSum[i - firstLen - secondLen];
            res = Math.max(res, firstSum + secondSum);
        }
        for (int i = secondLen; i <= nums.length - firstLen; i++) {
            int firstSum = prefixSum[i] - prefixSum[i - secondLen];
            int secondSum = prefixSum[i - secondLen] - prefixSum[i - secondLen - firstLen];
            res = Math.max(res, firstSum + secondSum);
        }
        return res;
    }
}