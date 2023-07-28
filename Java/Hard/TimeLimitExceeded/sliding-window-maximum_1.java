class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int maxIndex = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = k; i < nums.length; i++) {
            result[i - k] = nums[maxIndex];
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            } else if (maxIndex == i - k) {
                maxIndex = i - k + 1;
                for (int j = i - k + 1; j <= i; j++) {
                    if (nums[j] > nums[maxIndex]) {
                        maxIndex = j;
                    }
                }
            }
        }
        result[nums.length - k] = nums[maxIndex];
        return result;
    }
}