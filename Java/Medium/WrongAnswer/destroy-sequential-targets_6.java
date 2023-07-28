class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int res = 1;
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - prev > space) {
                prev = nums[i];
                res++;
            }
        }
        return res;
    }
}