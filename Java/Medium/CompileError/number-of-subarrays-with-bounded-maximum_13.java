class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int result = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int prevRightIndex = 0;
        while (rightIndex < nums.length) {
            if (nums[rightIndex] >= left && nums[rightIndex] <= right) {
                result += (rightIndex - prevRightIndex + 1);
                leftIndex = rightIndex + 1;
                prevRightIndex = leftIndex;
            } else if (nums[rightIndex] < left) {
                result += (rightIndex - leftIndex + 1);
            } else {
                prevRightIndex = rightIndex + 1;
                leftIndex = rightIndex + 1;
            }
            rightIndex++;
        }
        return result= 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                start = i + 1;
                end = i + 1;
                max = 0;
                continue;
            }
            if (nums[i] >= left) {
                max = i - start + 1;
            }
            if (nums[i] < left) {
                max = Math.max(max, i - start + 1);
            }
            ans += max;
        }
        return ans;
    }
}