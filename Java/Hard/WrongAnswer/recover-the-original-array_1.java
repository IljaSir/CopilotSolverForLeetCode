class Solution {
    public int[] recoverArray(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length / 2;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (nums[i] + nums[n + i]) / 2;
        }
        return res;
    }
}