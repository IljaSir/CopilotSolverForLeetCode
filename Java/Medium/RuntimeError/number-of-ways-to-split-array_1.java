class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int leftSum = preSum[i];
            int minRightIdx = i + 1;
            int maxRightIdx = n - 1;
            while (minRightIdx < maxRightIdx) {
                int midRightIdx = minRightIdx + (maxRightIdx - minRightIdx) / 2;
                if (preSum[midRightIdx] - leftSum < leftSum) {
                    minRightIdx = midRightIdx + 1;
                } else {
                    maxRightIdx = midRightIdx;
                }
            }
            int minRightSum = preSum[minRightIdx] - leftSum;
            if (minRightSum < leftSum) {
                continue;
            }
            int maxRightSum = preSum[n - 1] - leftSum;
            if (maxRightSum < leftSum) {
                continue;
            }
            int maxLeftIdx = i;
            int minLeftIdx = 0;
            while (minLeftIdx < maxLeftIdx) {
                int midLeftIdx = minLeftIdx + (maxLeftIdx - minLeftIdx) / 2;
                if (leftSum - preSum[midLeftIdx] <= preSum[n - 1] - preSum[midLeftIdx]) {
                    maxLeftIdx = midLeftIdx;
                } else {
                    minLeftIdx = midLeftIdx + 1;
                }
            }
            int maxLeftSum = leftSum - preSum[maxLeftIdx];
            if (maxLeftSum > preSum[n - 1] - preSum[maxLeftIdx]) {
                continue;
            }
            ans = (ans + minRightIdx - maxLeftIdx) % 1000000007;
        }
        return ans;
    }
}