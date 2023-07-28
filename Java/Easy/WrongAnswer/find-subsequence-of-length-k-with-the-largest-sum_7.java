class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[] result = new int[k];
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (k > 0) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = start; i <= end - k + 1; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            result[index++] = max;
            k--;
            start = maxIndex + 1;
        }
        return result;
    }
}