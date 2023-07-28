class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] result = new int[nums.length - k + 1];
        int maxIndex = 0;
        
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (maxIndex < i) {
                maxIndex = i;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] > nums[maxIndex]) {
                        maxIndex = j;
                    }
                }
            } else if (nums[i + k - 1] > nums[maxIndex]) {
                maxIndex = i + k - 1;
            }
            result[i] = nums[maxIndex];
        }
        
        return result;
    }
}