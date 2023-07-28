class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        res[0] = max;
        for (int i = 1; i < nums.length - k + 1; i++) {
            if (nums[i + k - 1] > max) {
                max = nums[i + k - 1];
                maxIndex = i + k - 1;
            }
            if (maxIndex < i) {
                max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }
}