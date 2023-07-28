class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int index = 0;
        while (end < nums.length) {
            if (nums[end] > max) {
                max = nums[end];
            }
            if (end - start + 1 == k) {
                result[index++] = max;
                if (nums[start] == max) {
                    max = Integer.MIN_VALUE;
                    for (int i = start + 1; i <= end; i++) {
                        if (nums[i] > max) {
                            max = nums[i];
                        }
                    }
                }
                start++;
            }
            end++;
        }
        return result;
    }
}