class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] - res > value) {
                break;
            }
            value -= num;
    }
}