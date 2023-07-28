class Solution {
    public int sumOfBeauties(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            left[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            right[i] = min;
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > left[i - 1] && nums[i] < right[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }
}