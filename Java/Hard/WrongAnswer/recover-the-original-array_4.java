class Solution {
    public int[] recoverArray(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n / 2];
        Arrays.sort(nums);
        int k = nums[n / 2] - nums[n / 2 - 1];
        for (int i = 0; i < n / 2; ++i) {
            res[i] = nums[i] + k;
        }
        return res;
    }
}