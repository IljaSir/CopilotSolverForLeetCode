class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int leftSum = prefixSum[i] - prefixSum[mid] + nums[mid];
                int rightSum = suffixSum[i + 1] - suffixSum[mid + 1];
                if (leftSum < rightSum) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int leftSum = prefixSum[i] - prefixSum[left] + nums[left];
            int rightSum = suffixSum[i + 1] - suffixSum[left + 1];
            int diff = Math.abs(leftSum / (i - left + 1) - rightSum / (n - i - 1));
            if (diff < min) {
                min = diff;
                minIndex = i;
            }
        }
        return minIndex;
    }
}