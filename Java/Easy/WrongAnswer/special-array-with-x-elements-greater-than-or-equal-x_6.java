class Solution {
    public int specialArray(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int x = n - i;
            if (nums[i] >= x) return x;
        }
        return -1;
    }
}