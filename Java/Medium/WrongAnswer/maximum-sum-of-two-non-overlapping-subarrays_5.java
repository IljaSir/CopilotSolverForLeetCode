class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 0; i <= n - firstLen; i++) {
            int firstSum = preSum[i + firstLen] - preSum[i];
            int secondSum = 0;
            for (int j = 0; j <= n - secondLen; j++) {
                if (j >= i && j <= i + firstLen) {
                    continue;
                }
                secondSum = Math.max(secondSum, preSum[j + secondLen] - preSum[j]);
            }
            res = Math.max(res, firstSum + secondSum);
        }
        for (int i = 0; i <= n - secondLen; i++) {
            int secondSum = preSum[i + secondLen] - preSum[i];
            int firstSum = 0;
            for (int j = 0; j <= n - firstLen; j++) {
                if (j >= i && j <= i + secondLen) {
                    continue;
                }
                firstSum = Math.max(firstSum, preSum[j + firstLen] - preSum[j]);
            }
            res = Math.max(res, firstSum + secondSum);
        }
        return res;
    }
}