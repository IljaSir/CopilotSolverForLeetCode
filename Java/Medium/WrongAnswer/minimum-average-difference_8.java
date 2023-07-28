class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int[] preSum = new int[n];
        int[] preSumSq = new int[n];
        preSum[0] = nums[0];
        preSumSq[0] = nums[0] * nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
            preSumSq[i] = preSumSq[i - 1] + nums[i] * nums[i];
        }
        int minIndex = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int leftSum = preSum[i];
            int leftSumSq = preSumSq[i];
            int leftLen = i + 1;
            int rightSum = preSum[n - 1] - preSum[i];
            int rightSumSq = preSumSq[n - 1] - preSumSq[i];
            int rightLen = n - leftLen;
            int leftAvg = leftSum / leftLen;
            int rightAvg = rightSum / rightLen;
            int leftAvgSq = leftSumSq / leftLen;
            int rightAvgSq = rightSumSq / rightLen;
            int leftDiff = leftAvgSq - leftAvg * leftAvg;
            int rightDiff = rightAvgSq - rightAvg * rightAvg;
            int diff = Math.abs(leftDiff - rightDiff);
            if (diff < minDiff) {
                minIndex = i;
                minDiff = diff;
            }
        }
        return minIndex;
    }
}