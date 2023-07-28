class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[] res = new int[k];
        int len = nums.length;
        int start = 0;
        int end = len - k;
        int index = 0;
        while (k > 0) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    index = i;
                }
            }
            res[len - k] = max;
            start = index + 1;
            end++;
            k--;
        }
        return res;
    }
}