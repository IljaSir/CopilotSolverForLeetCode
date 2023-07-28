class Solution {
    public int pivotIndex(int[] nums) {
        
        int n = nums.length;
        int[] leftSum = new int[n + 1];
        int[] rightSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}