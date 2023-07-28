class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[left[i - 1]]) {
                left[i] = i;
            } else {
                left[i] = left[i - 1];
            }
        }
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[right[i + 1]]) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, right[i] - left[i]);
        }
        return max;
    }
}