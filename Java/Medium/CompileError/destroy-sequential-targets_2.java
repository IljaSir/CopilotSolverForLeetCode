class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int res = 1;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= sprce) {
                ++j;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}