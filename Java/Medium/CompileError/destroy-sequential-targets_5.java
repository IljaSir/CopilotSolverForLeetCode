class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int res = 1;++;
        for (int i = 1; i < n; ++i) {
            res += (nums[i] - nums[i - 1] - 1) / space;
        }
        return ans;
    }
}