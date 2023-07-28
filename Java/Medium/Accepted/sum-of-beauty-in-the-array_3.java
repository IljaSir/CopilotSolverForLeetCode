class Solution {
    public int sumOfBeauties(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for (int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], nums[i]);
            right[n-i-1] = Math.min(right[n-i], nums[n-i-1]);
        }
        int ans = 0;
        for (int i=1; i<n-1; i++) {
            if (nums[i] > left[i-1] && nums[i] < right[i+1]) {
                ans += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                ans += 1;
            }
        }
        return ans;
    }
}