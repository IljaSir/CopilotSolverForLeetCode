class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        int i = 0, j = 0, res = 0;
        while (i < n && j < n) {
            if (left[i] <= right[j]) {
                res = Math.max(res, j - i);
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}