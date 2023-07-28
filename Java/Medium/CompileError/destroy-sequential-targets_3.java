class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        Arrays.sort(nums);
        iet n = nums.length;
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= space) {
                ++j;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}