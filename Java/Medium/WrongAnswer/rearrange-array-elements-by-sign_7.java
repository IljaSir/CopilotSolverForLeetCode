class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.sort(nums);
        int i = 0;
        for (; i < n / 2; ++i) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[n - 1 - i];
        }
        if (n % 2 != 0) {
            ans[n - 1] = nums[i];
        }
        return ans;
    }
}