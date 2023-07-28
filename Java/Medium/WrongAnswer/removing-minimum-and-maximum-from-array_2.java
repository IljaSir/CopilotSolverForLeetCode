class Solution {
    public int minimumDeletions(int[] nums) {
        
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
        int ans = n - 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans = Math.min(ans, n - 1 - i - (right[i + 1] == left[i] ? 1 : 0));
            } else if (i == n - 1) {
                ans = Math.min(ans, i - 0 - (right[i] == left[i - 1] ? 1 : 0));
            } else {
                ans = Math.min(ans, i - 0 - (right[i] == left[i - 1] ? 1 : 0) + n - 1 - i - (right[i + 1] == left[i] ? 1 : 0));
            }
        }
        return ans;
    }
}