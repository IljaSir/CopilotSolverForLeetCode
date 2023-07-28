class Solution {
    public int[] recoverArray(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int k = (nums[n/2] - nums[n/2-1]) / 2;
        int[] ans = new int[n/2];
        for (int i = 0; i < n/2; i++) {
            ans[i] = nums[i] + k;
        }
        return ans;
    }
}