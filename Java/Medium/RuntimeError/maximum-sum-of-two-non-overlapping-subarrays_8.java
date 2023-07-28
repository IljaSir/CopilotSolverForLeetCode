class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int n = nums.length;
        int[] preSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i + firstLen <= n; i++) {
            int firstSum = preSum[i+firstLen] - preSum[i];
            ans = Math.max(ans, firstSum + maxSum(preSum, i, secondLen));
            ans = Math.max(ans, firstSum + maxSum(preSum, i + firstLen, secondLen));
        }
        return ans;
    }
    
    private int maxSum(int[] preSum, int start, int len) {
        int n = preSum.length;
        int ans = 0;
        for (int i = start; i + len <= n; i++) {
            int sum = preSum[i+len] - preSum[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}