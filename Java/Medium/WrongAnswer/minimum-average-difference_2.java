class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = -1;
        for (int i = 0; i < n - 1; i++) {
            int leftSum = prefixSum[i];
            int leftCount = i + 1;
            int rightSum = prefixSum[n - 1] - prefixSum[i];
            int rightCount = n - i - 1;
            int leftAverage = leftSum / leftCount;
            int rightAverage = rightSum / rightCount;
            int diff = Math.abs(leftAverage - rightAverage);
            if (diff < minDiff) {
                minDiff = diff;
                minDiffIndex = i;
            }
        }
        return minDiffIndex;
    }
}