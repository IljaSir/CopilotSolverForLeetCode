class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        result[0] = max;
        for (int i = k; i < nums.length; i++) {
            if (i - maxIndex >= k) {
                max = Integer.MIN_VALUE;
                for (int j = i - k + 1; j <= i; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            } else {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            result[i - k + 1] = max;
        }
        return result;
    }
}