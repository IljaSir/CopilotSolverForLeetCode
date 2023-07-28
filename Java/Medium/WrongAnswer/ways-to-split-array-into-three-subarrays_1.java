class Solution {
    public int waysToSplit(int[] nums) {
        
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int leftSum = prefixSum[i];
            int leftIndex = binarySearch(prefixSum, i + 1, n - 2, 2 * leftSum);
            if (leftIndex == -1) {
                continue;
            }
            int rightIndex = binarySearch(prefixSum, leftIndex, n - 1, leftSum + prefixSum[n - 1]);
            if (rightIndex == -1) {
                continue;
            }
            res += rightIndex - leftIndex + 1;
            res %= 1000000007;
        }
        return res;
    }
    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start < nums.length ? start : -1;
    }
}