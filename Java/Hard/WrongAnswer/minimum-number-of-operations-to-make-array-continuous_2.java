class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int res = n;
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < n && nums[j] - nums[i] < n) {
                ++j;
            }
            if (j - i == n - 1 && nums[j - 1] - nums[i] == n - 1) {
                res = Math.min(res, n - j + i);
            }
        }
        return res;
    }
}