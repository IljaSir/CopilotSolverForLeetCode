class Solution {
    public int[] recoverArray(int[] nums) {
        
        int n = nums.length / 2;
        Arrays.sort(nums);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (nums[i] + nums[i + n]) / 2;
        }
        return ans;
    }
}