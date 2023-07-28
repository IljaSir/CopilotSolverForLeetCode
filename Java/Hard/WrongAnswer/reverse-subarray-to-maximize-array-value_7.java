class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans += Math.abs(nums[i] - nums[i + 1]);
            max = Math.max(max, Math.max(nums[i], nums[i + 1]));
            min = Math.min(min, Math.min(nums[i], nums[i + 1]));
        }
        int ans1 = ans;
        int ans2 = ans;
        int ans3 = ans;
        int ans4 = ans;
        for (int i = 0; i < n - 1; i++) {
            ans1 = Math.max(ans1, ans - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i] - min));
            ans2 = Math.max(ans2, ans - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i + 1] - min));
            ans3 = Math.max(ans3, ans - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i] - max));
            ans4 = Math.max(ans4, ans - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i + 1] - max));
        }
        int ans5 = ans;
        for (int i = 0; i < n - 1; i++) {
            ans5 = Math.max(ans5, ans - Math.abs(nums[i] - nums[i + 1]) + Math.abs(max - min));
        }
        return Math.max(ans1, Math.max(ans2, Math.max(ans3, Math.max(ans4, ans5))));
    }
}