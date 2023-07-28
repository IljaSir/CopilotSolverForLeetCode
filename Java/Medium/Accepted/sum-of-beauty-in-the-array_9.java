class Solution {
    public int sumOfBeauties(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i + 1]);
            right[i] = min;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i - 1]);
            left[i] = max;
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > left[i] && nums[i] < right[i]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}