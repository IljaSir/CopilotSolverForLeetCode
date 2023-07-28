class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i] < nums[left[i - 1]] ? i : left[i - 1];
        }
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i] > nums[right[i + 1]] ? i : right[i + 1];
        }
        int i = 0, j = 0, ans = 0;
        while (i < n && j < n) {
            if (nums[left[i]] <= nums[right[j]]) {
                ans = Math.max(ans, right[j] - left[i]);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }
}